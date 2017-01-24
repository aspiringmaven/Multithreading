package concurrency.in.practice.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//4 thread wait and callback happen | post call back 4 thread proceed with their stuff.
public class App {

	public App() {
	}

	public static void main(String[] args) {
		hang();
		System.out.println("DOne!");

	}
	
	public static void logic1() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Cab());

		new Thread(new Traveler(cyclicBarrier)).start();
		new Thread(new Traveler(cyclicBarrier)).start();
		new Thread(new Traveler(cyclicBarrier)).start();
		new Thread(new Traveler(cyclicBarrier)).start();
	}
	
	public static void hang() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Cab());
		ExecutorService executorService = Executors.newFixedThreadPool(3);//3 makes it starving..
		executorService.submit(new Traveler(cyclicBarrier));
		executorService.submit(new Traveler(cyclicBarrier));
		executorService.submit(new Traveler(cyclicBarrier));
		executorService.submit(new Traveler(cyclicBarrier));
		executorService.shutdown();
	}
	
}

class Traveler implements Runnable {
	private final CyclicBarrier cyclicBarrier;

	/**
	 * @param cyclicBarrier
	 */
	public Traveler(CyclicBarrier cyclicBarrier) {
		super();
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(4);
			System.out.println(Thread.currentThread().getName() + " Boarded Cab.");
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()  + "await finish");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

	public CyclicBarrier getCyclicBarrier() {
		return cyclicBarrier;
	}

}

class Cab implements Runnable {

	/**
	 * @param cyclicBarrier
	 */
	public Cab() {
		super();
	}

	@Override
	public void run() {
		System.out.println("Cab STart..");
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cab Running..");
	}

}