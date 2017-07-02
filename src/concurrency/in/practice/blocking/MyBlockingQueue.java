package concurrency.in.practice.blocking;

import java.util.ArrayList;

public class MyBlockingQueue<E> {
	
	private static final int SIZE = 10;
	private ArrayList<E> queue = new ArrayList<E>(SIZE);

	public MyBlockingQueue() {
		
	}
	
	
	public synchronized E dequeue() throws InterruptedException {
		while(this.queue.isEmpty()) {
			this.wait();
		}
		try {
			return this.queue.remove(0);
		} finally {
			this.notifyAll();
		}
				
				
	}
	
	public synchronized void enqueue(E data) throws InterruptedException {
		while(queue.size() == SIZE) {
			this.wait();
		}
		this.queue.add(data);
		this.notifyAll();
	}
	

}
