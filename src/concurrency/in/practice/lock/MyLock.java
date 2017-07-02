package concurrency.in.practice.lock;

public class MyLock {

	private volatile boolean  isLock;
	
	public MyLock() {
	}
	
	public synchronized void lock() throws InterruptedException {
		while(isLock) {
			this.wait();
		}
		isLock = true;
	}
	
	public synchronized void unLock() {
		isLock = false; notify();
	}

}
