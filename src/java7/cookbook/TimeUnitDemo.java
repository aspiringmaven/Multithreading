package java7.cookbook;

import java.util.concurrent.TimeUnit;

public class TimeUnitDemo implements Runnable{
	
	public static void main(String[] args) {
		new Thread(new TimeUnitDemo()).start();
	}

	@Override
	public void run() {
		System.out.println("Start");
		try {
			/*
			 * This is new Util
			 */
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("End");
	}
}