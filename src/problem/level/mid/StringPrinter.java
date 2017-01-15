package problem.level.mid;

public class StringPrinter implements Runnable{
	
	private final int rank;
	private final TurnLock turnLock;
	private final String string;
	
	public StringPrinter(int rank, TurnLock turnLock,String str) {
		super();
		this.rank = rank;
		this.turnLock = turnLock;
		this.string = str;
	}
	
	public static void main(String[] args) {
		String string = "techtogether";
		TurnLock turnLock = new TurnLock();
		for(int i=string.length()-1;i>=0;i--) {
			new Thread(new StringPrinter(i, turnLock, string)).start();
		}
	}

	public TurnLock getTurnLock() {
		return turnLock;
	}

	public int getRank() {
		return rank;
	}
/*
 * (non-Javadoc)
 * @see java.lang.Runnable#run()
 */
	@Override
	public void run() {	
		boolean running = true; // BC this will kill the thread after run
		while(turnLock.getTurn() < string.length() && running) {
			synchronized(turnLock) {
				//wait in while till get your turn
				while(rank != turnLock.getTurn() && rank < string.length()) {
					try {
						turnLock.wait();
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
				 System.out.print("|"+string.charAt(rank));
				 turnLock.setTurn(getRank()+1);
				 turnLock.notifyAll();
				 running = !running;
			}
		}
	}
}

class TurnLock {
	
	private volatile int turn;
	
	public TurnLock() {
		this.turn = 0;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
}