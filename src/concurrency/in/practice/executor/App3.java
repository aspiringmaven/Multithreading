package concurrency.in.practice.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App3 {

	public static void main(String[] args) {
		Future<String> future = call();
		
		try {
			System.out.println("MSG from Callable >  "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Future<String> call() {
		return Executors.newSingleThreadExecutor().submit( new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Call Start....");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Call End......");
				return "Tech Together";
			}
		});
	}

}
