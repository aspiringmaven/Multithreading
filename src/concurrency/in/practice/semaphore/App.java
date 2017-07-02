package concurrency.in.practice.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


//only three user can read book parallel.
public class App {

	public App() {

	}
	
	public static void main(String[] args) {
		driver();
	}

	public static void driver() {
		Semaphore semaphore = new Semaphore(1);
		
		for(int i=0;i<5;i++) {
			new Thread(new Book(semaphore)).start();
		}
	}
	
}

class Book implements Runnable {

	private final Semaphore semaphore;
	
	/**
	 * @param semaphore
	 */
	public Book(Semaphore semaphore) {
		super();
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "    waiting...");
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "  start reading...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Thread.currentThread().getName() + "  end reading...");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

}