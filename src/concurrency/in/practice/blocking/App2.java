package concurrency.in.practice.blocking;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App2 {

	public static final int SIZE = 10;

	public App2() {

	}
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new ProducerJob(list));
		executorService.submit(new ConsumerJob(list));
		executorService.shutdown();
	}

}

class ProducerJob implements Runnable {

	private final List<Integer> queue;

	/**
	 * @param queue
	 */
	public ProducerJob(List<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				
				while(queue.size() >= App2.SIZE) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (queue.size() <= App2.SIZE) {
					int put = new Random().nextInt(100);
					System.out.println("Prodecer >> " + put);
					queue.add(put);
					try {
						TimeUnit.SECONDS.sleep(1);
						queue.notifyAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				} 
				
			}
		}
	}

	public List<Integer> getQueue() {
		return queue;
	}

}

class ConsumerJob implements Runnable{

	private final List<Integer> queue;

	/**
	 * @param queue
	 */
	public ConsumerJob(List<Integer> queue) {
		super();
		this.queue = queue;
	}

	public List<Integer> getQueue() {
		return queue;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(!queue.isEmpty()) {
					int pop = queue.remove(0);
					System.out.println("Consumer >>>> "+pop);
					try {
						TimeUnit.SECONDS.sleep(1);
						queue.notifyAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}
		}
		
	}
}
