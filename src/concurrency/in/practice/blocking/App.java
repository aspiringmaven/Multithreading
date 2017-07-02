package concurrency.in.practice.blocking;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static final int SIZE = 10;

	public static void main(String[] args) {
		PriorityBlockingQueue<Process> queue = new PriorityBlockingQueue<Process>(App.SIZE);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		executorService.submit(new Producer(queue));
		executorService.submit(new Producer(queue));
		executorService.submit(new Consumer(queue));
		
		executorService.shutdown();

	}
}

class Producer implements Runnable {

	private final BlockingQueue<Process> queue;

	/**
	 * @param queue
	 */
	public Producer(BlockingQueue<Process> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			
			while(queue.size() < App.SIZE) {
				Process process = new Process(new Random().nextInt(100));
				System.out.println(process + " Scheduled !");
				queue.add(process);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public BlockingQueue<Process> getQueue() {
		return queue;
	}

}

class Consumer implements Runnable {

	private final BlockingQueue<Process> queue;

	/**
	 * @param queue
	 */
	public Consumer(BlockingQueue<Process> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			while(!queue.isEmpty()) {
				System.out.println();
				System.out.println(queue);
				Process process = queue.poll();
				System.out.println(" >>>>>>>>>>> "+ process + " got CPU Cycle!");
				System.out.println();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public BlockingQueue<Process> getQueue() {
		return queue;
	}

}

class Process implements Comparable<Process> {
	private int priority;

	/**
	 * @param priority
	 */
	public Process(int priority) {
		super();
		this.priority = priority;
	}

	@Override
	public int compareTo(Process process) {
		return this.getPriority()-  process.getPriority() ; //lowest Priority First
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Process [priority=");
		builder.append(priority);
		builder.append("]");
		return builder.toString();
	}

}
