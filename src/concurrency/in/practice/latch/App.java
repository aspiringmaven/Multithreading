package concurrency.in.practice.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public App() {
	}

	// Do Operation when source and Destinations are Ready
	public static void main(String[] args) {
		driver2();
	}

	public static void driver() {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		new Thread(new Operation(countDownLatch)).start();
		new Thread(new Source(countDownLatch)).start();
		new Thread(new Destination(countDownLatch)).start();
	}

	public static void driver2() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CountDownLatch countDownLatch = new CountDownLatch(2);
		executorService.submit(new Operation(countDownLatch));
		executorService.submit(new Source(countDownLatch));
		executorService.submit(new Destination(countDownLatch));
		executorService.shutdown();
	}

}

class Source implements Runnable {

	private final CountDownLatch countDownLatch;

	/**
	 * @param countDownLatch
	 */
	public Source(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Connecting Source...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("...Source Connected...");
		countDownLatch.countDown();
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

}

class Destination implements Runnable {

	private final CountDownLatch countDownLatch;

	/**
	 * @param countDownLatch
	 */
	public Destination(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Connecting Destination...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("...Destination Connected...");
		countDownLatch.countDown();
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

}

class Operation implements Runnable {

	private final CountDownLatch countDownLatch;

	/**
	 * @param countDownLatch
	 */
	public Operation(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			System.out.println("Operation waiting for Source and Destination to be ready.");
			countDownLatch.await();
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Operation Executed.");
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

}
