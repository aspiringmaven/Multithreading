package me.sumitkawatra.java8.concept.lambda;

public class Lambda1 {
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getId());
		
		/**
		 * inline impl for runnable
		 */
		new Thread( () -> {System.out.println(Thread.currentThread().getId());}).start();
		
		
	}
}
