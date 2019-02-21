package me.sumitkawatra.java8.concept.async;

import java.util.concurrent.Semaphore;

public class RestrictedClass {
	
	/**
	 * only 10 thread can access parllel.
	 */
	private static final Semaphore resource = new Semaphore(10);
	
	public void method() throws InterruptedException {
		try {
			resource.acquire();
			
		}finally {
			resource.release();
		}
	}

}
