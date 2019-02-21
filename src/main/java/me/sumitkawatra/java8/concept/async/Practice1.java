package me.sumitkawatra.java8.concept.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Complete able Future example.
 * 
 * @author sumkawat
 *
 */
public class Practice1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		practice3();
		System.out.println(practice1().get());
		System.out.println(practice2().get());
	}

	/**
	 * You have privilege to make CompleteableFuture complete when you have value to
	 * pass.
	 * 
	 * @return
	 */
	public static CompletableFuture<String> practice1() {
		CompletableFuture<String> future = CompletableFuture.completedFuture("Hello World !!!");
		return future;
	}

	/**
	 * when CompleteFuture run new thread and complete the future.
	 * 
	 * @return
	 */
	public static CompletableFuture<String> practice2() {
		CompletableFuture<String> completeableFuture = new CompletableFuture<>();

		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					completeableFuture.complete("Hello World Async");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				;

			}
		};

		new Thread(r).start();
		return completeableFuture;
	}

	public static void practice3() {

		CompletableFuture.runAsync(() -> {

			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Hello Worl");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});
	}

}
