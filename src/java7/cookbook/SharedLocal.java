package java7.cookbook;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SharedLocal implements Runnable{
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Thread(new SharedLocal()).start();
		}
	}

	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	@Override
	public void run() {
		Integer i = new Random().nextInt(100);
		System.out.println(Thread.currentThread().getId() +" generated "+i);
		threadLocal.set(i);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() +" got the val "+threadLocal.get());
	}

}
