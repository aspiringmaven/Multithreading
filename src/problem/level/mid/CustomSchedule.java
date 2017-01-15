package problem.level.mid;
/*
 * Dheeru Wants to run threads with extra cycle
 * 
 */
public class CustomSchedule implements Runnable {
	private int rank;
	private int cycle;
	private final JLock lock;
	private final int threadCount;

	public CustomSchedule(int rank, int cycle, JLock lock,int threadCount) {
		super();
		this.rank = rank;
		this.cycle = cycle;
		this.lock = lock;
		this.threadCount = threadCount;
	}
	
	public static void main(String[] args) {
		JLock jLock = new JLock(1, 50);
		Thread thread = new Thread(new CustomSchedule(1, 2, jLock, 4));
		Thread thread2 = new Thread(new CustomSchedule(2, 2, jLock, 4));
		Thread thread3 = new Thread(new CustomSchedule(3, 2, jLock, 4));
		Thread thread4 = new Thread(new CustomSchedule(4, 1, jLock, 4));
		
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		//System.out.println("Done!");
	}

	public JLock getLock() {
		return lock;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
		while (this.getLock().getStart() <= this.getLock().getEnd()) {
			synchronized (this.getLock()) {
				while (this.getLock().getTurn() != this.getRank()) {
					try {
						this.getLock().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				int myCycle =0;
				
				while(myCycle != this.getCycle()) {
					System.out.println(Thread.currentThread().getId()+" :: "+this.getLock().getStart());					
					myCycle++;
				}
				
				this.getLock().setStart(this.getLock().getStart()+1);
				if(this.rank >= this.threadCount) {
					this.getLock().setTurn(1);
				} else {
					this.getLock().setTurn(this.getLock().getTurn()+1);
				}
				this.getLock().notifyAll();				
			}
		}

	}

	public int getThreadCount() {
		return threadCount;
	}

}

class JLock {
	private int start;
	private int end;
	private int turn;

	public JLock(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		this.turn = 1;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
}