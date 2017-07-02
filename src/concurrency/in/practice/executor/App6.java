package concurrency.in.practice.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App6 {

	public App6() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
		
//		
//		ex.scheduleWithFixedDelay(new TimeJob(), 10, 2, TimeUnit.SECONDS);
//		ex.sc
	}

}


class JustJOb implements Runnable {

	@Override
	public void run() {
		System.out.println();
		
	}
	
}

class TimeJob implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int num = new Random().nextInt(100);
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Thread " + Thread.currentThread().getId() + " returning " + num);
		return num;
	}
	
}