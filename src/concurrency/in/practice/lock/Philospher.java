package concurrency.in.practice.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Philospher implements Runnable {

	private final String name;
	private final ReentrantLock leftFork;
	private final ReentrantLock rightFork;
	
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		ReentrantLock []forks = new ReentrantLock[6];
		for(int i=0;i<forks.length;i++) {
			forks[i] = new ReentrantLock(true);
		}
		
		executorService.submit(new Philospher("A", forks[0], forks[1]));
		executorService.submit(new Philospher("B", forks[1], forks[2]));
		executorService.submit(new Philospher("C", forks[2], forks[3]));
		executorService.submit(new Philospher("D", forks[3], forks[4]));
		executorService.submit(new Philospher("E", forks[4], forks[5]));
		executorService.submit(new Philospher("F", forks[5], forks[0]));
		
		executorService.shutdown();
		
	}

	/**
	 * @param name
	 * @param leftFork
	 * @param rightFork
	 */
	public Philospher(String name, ReentrantLock leftFork, ReentrantLock rightFork) {
		super();
		this.name = name;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	@Override
	public void run() {
		while (true) {
			try {	
				if(leftFork.tryLock()) {
					if(rightFork.tryLock()) {
						try {
							System.out.println("Philospher " + name  + " Eating............!!");
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} 
				
				
			} finally {
				if (leftFork.isHeldByCurrentThread())
					leftFork.unlock();
				if (rightFork.isHeldByCurrentThread())
					rightFork.unlock();
			}
			System.out.println("Philospher " + name  + " Waiting...!!");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the leftFork
	 */
	public ReentrantLock getLeftFork() {
		return leftFork;
	}

	/**
	 * @return the rightLock
	 */
	public ReentrantLock getRightFork() {
		return rightFork;
	}

}
