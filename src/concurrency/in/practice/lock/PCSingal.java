package concurrency.in.practice.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCSingal {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Lock lock = new ReentrantLock();
		Condition notFull = lock.newCondition();
		Condition notEmpty = lock.newCondition();
		
		new Thread(new Producer(list, lock, notFull,notEmpty)).start();
		new Thread(new Consumer(list, lock, notFull,notEmpty)).start();
	}

}

class Producer implements Runnable{

	
	private List<Integer> queue;
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;

	/**
	 * @param queue
	 * @param lock
	 * @param condition
	 */
	public Producer(List<Integer> queue, Lock lock, Condition notFull,Condition notEmpty) {
		super();
		this.queue = queue;
		this.lock = lock;
		this.notFull = notFull;
		this.notEmpty = notEmpty;
	}

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				
				while (queue.size() >= 10) {
					notEmpty.await();
				}
				
				int num = new Random().nextInt(100);
				System.out.println("added " + num);
				queue.add(num);
				notFull.signal();
				TimeUnit.SECONDS.sleep(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
		
		
	}
	
}





class Consumer implements Runnable{

	
	private List<Integer> queue;
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;

	/**
	 * @param queue
	 * @param lock
	 * @param condition
	 */
	public Consumer(List<Integer> queue, Lock lock, Condition notFull,Condition notEmpty) {
		super();
		this.queue = queue;
		this.lock = lock;
		this.notFull = notFull;
		this.notEmpty = notEmpty;
	}

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				while (queue.isEmpty()) {
					notFull.await();
				}
				int num = queue.remove(0);
				System.out.println("Consumed " + num);
				TimeUnit.SECONDS.sleep(1);
				notEmpty.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
	}

}