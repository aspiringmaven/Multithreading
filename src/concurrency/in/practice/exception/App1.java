package concurrency.in.practice.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class App1 {
	
	public static void main(String[] args) {
		fun();
	}
	
	
	public static void fun() {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		FutureTask<?> future = (FutureTask<?>) executorService.submit(new Run());
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(future.isDone());
		System.out.println(future.isCancelled());
		
	}

}


class Run implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}
}