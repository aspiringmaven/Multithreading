package concurrency.in.practice.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class App {

	public static void main(String[] args) {
		cachePool();
	}

	public static void fixPool() {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 7; i++) {
			executor.submit(new Task(i));
		}
		executor.shutdown();
	}
	
	
	public static void singleThread() {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		for(int i=0;i<3;i++) {
			executor.submit(new Task(i));
		}
		executor.shutdown();
	}
	
	public static void cachePool() {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i<10;i++) {
			executor.submit(new Task(i));
		}
		executor.shutdown();
	}
	

}

class Task implements Runnable {

	private final int id;

	/**
	 * @param id
	 */
	public Task(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId() + " Starting...   > " + id);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() + " End.......     > " + id);
	}

	public int getId() {
		return id;
	}

}
