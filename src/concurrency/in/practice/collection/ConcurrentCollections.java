package concurrency.in.practice.collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollections {

	public ConcurrentCollections() {
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		DelayQueue<DelayedMsg> q = new DelayQueue<>();
		
		q.put(new DelayedMsg(2000, "after 2 second"));
		q.put(new DelayedMsg(4000, "after 4 second"));
		q.put(new DelayedMsg(6000, "after 6 second"));
		q.put(new DelayedMsg(8000, "after 8 second"));
		
		while (!q.isEmpty()) {
			System.out.println("start...");
			System.out.println(q.take());
		}
		
	}

}


class DelayedMsg implements Delayed {

	private int duration;
	private String message;
	
	/**
	 * @param time
	 * @param message
	 */
	public DelayedMsg(int duration, String message) {
		super();
		this.duration = duration;
		this.message = message;
	}

	@Override
	public int compareTo(Delayed o) {
		return this.duration - ((DelayedMsg)o).duration;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		 long diff = duration - System.currentTimeMillis();
	     return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DelayedMsg [duration=");
		builder.append(duration);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
	
}