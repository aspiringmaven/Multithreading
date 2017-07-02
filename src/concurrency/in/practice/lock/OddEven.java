package concurrency.in.practice.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven {

	public OddEven() {
	}
	
	public static void main(String[] args) {
		Lock lock =  new ReentrantLock();
		Condition condition = lock.newCondition();
		Rank rank = new Rank();
		
		new Thread(new Runner(lock, condition, rank, 0)).start();
		new Thread(new Runner(lock, condition, rank, 1)).start();
		
	}

}

class Rank {
	private volatile int num;

	public int getNum() {
		return num;
	}
	public void increment() {
		num++;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

class Runner implements Runnable {
	
	private final Lock lock;
	private final Condition condition;
	private final Rank rank;
	private final int TURN;
	

	/**
	 * @param lock
	 * @param condition
	 */
	public Runner(Lock lock, Condition condition, Rank rank, int turn) {
		super();
		this.lock = lock;
		this.condition = condition;
		this.rank = rank;
		this.TURN = turn;
	}
	
	

	/**
	 * @return the lock
	 */
	public Lock getLock() {
		return lock;
	}

	/**
	 * @return the condition
	 */
	public Condition getCondition() {
		return condition;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				while (rank.getNum()%2 != getTURN()) {
					condition.await();
				}
				System.out.println(TURN+"   "+rank.getNum());
				TimeUnit.SECONDS.sleep(1);
				rank.increment();
				condition.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}



	public Rank getRank() {
		return rank;
	}



	public int getTURN() {
		return TURN;
	}

}