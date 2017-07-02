package concurrency.in.practice.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App5 {

	public App5() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ExecutorService exService = Executors.newCachedThreadPool();
		System.out.println("");
		for(int i=0;i<100;i++)
		exService.execute(new RequestJob());
		System.out.println("");
		exService.shutdown();
	}

}

class RequestJob implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
