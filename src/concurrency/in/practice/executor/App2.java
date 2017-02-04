package concurrency.in.practice.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * Future from callable
 * @author SumitKawatra
 *
 */
public class App2 {

	public static void main(String[] args) {
		System.out.println("Begin Code!");

		Future<?> future = Foo();
		
		while(!future.isDone());
		System.out.println("Should after thread finish");
		
		try {
			System.out.println("Got Result " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("End Code!");
	}

	public static Future<?> Foo() {
		return Executors.newSingleThreadExecutor().submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Start Thread.....");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finish THread...");
			}
		});
	}

}
