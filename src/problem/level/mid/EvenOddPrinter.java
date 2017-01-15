package problem.level.mid;

public class EvenOddPrinter implements Runnable{
	
	private final int divisor;
	private final Lock lock;	
	
	public EvenOddPrinter(int divisor, Lock lock) {
		super();
		this.divisor = divisor;
		this.lock = lock;
	}
	
	public static void main(String[] args) {
		Lock lock =  new Lock(0,30);
		new Thread(new EvenOddPrinter(0, lock)).start();
		new Thread(new EvenOddPrinter(1, lock)).start();
	}

	public Lock getLock() {
		return lock;
	}

	public int getDivisor() {
		return divisor;
	}

	@Override
	public void run() {
		while(lock.getStart() <= lock.getEnd()) {
			synchronized (lock) {
				while(lock.getStart()%2 != divisor ) {
					try {
						lock.wait();
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
				if(lock.getStart() <= lock.getEnd())
				System.out.println("Thread : "+Thread.currentThread().getId()+" -->> "+lock.getStart());
				lock.setStart(lock.getStart()+1);
				lock.notifyAll();
			}
			
		}		
	}
}

class Lock {
	private volatile int start;
	private volatile int end;

	public Lock() {

	}

	public Lock(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
}
