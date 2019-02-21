package me.sumitkawatra.java8.concept.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Practice2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		hello();
		System.out.println(hello2().get());
	}
	
	/**
	 * This is to accepting the result after a future is complete 
	 */
	public static CompletableFuture<String> hello() {

		CompletableFuture<String> future = new CompletableFuture<>();

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					future.complete("World");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();;
		
		future.thenAccept(s -> {
			System.out.println("Hello " + s);
		});

		return future;
	}
	
	/**
	 * This is to applying something on completeableFuture result.
	 * @return
	 */
	public static CompletableFuture<String> hello2() {

		CompletableFuture<String> future = CompletableFuture.completedFuture("Hello World");
	
		return future.thenApply(s -> {return s.toUpperCase();});
		
	}

}
