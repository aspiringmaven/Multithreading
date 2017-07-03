package concurrency.in.practice.exception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Scanner;

public class App2 {
	
	public static void main(String[] args) {
		Thread t =  new Thread(new Work());
		t.setUncaughtExceptionHandler(new handler());
		t.start();
		
	}

}


class Work implements Runnable {

	@Override
	public void run() {
		System.out.println("running....");
//		throw new RuntimeException("Foooooo");
		
		throw new OutOfMemoryError("");
	}
	
}


class handler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable exception) {
		System.out.println(thread.getId() + "    " + exception);
		
	}
	
}
