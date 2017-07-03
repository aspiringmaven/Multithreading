package concurrency.in.practice.exception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class App3 {
	public static void main(String[] args) {
		foo();
	}
	
	public static void foo() {
		
		
		ThreadFactory factory =  new MyThreadFactory();
		
		ExecutorService executor =  Executors.newFixedThreadPool(2, factory);
				
		
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running.....");
				throw new RuntimeException(" Booooom");
			}
		});
		
				
	}
	
}



class MyThreadFactory implements ThreadFactory {

	MyHandler handler =  new MyHandler();
	
	@Override
	public Thread newThread(Runnable r) {
		System.out.println("This is called");
		Thread t  = new Thread(r);
		t.setUncaughtExceptionHandler(handler);
		return t;
	}
	
}


class MyHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable exception) {
		System.out.println(thread.getId() + "    " + exception);
		
	}
	
}