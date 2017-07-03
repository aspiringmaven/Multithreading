package concurrency.in.practice.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedObject implements Delayed{
	
	private long startTime;
	private String name;
	
	public DelayedObject(long delay, String name) {
		super();
		this.startTime = System.currentTimeMillis() + delay;
		this.name = name;
	}

	@Override
	public int compareTo(Delayed delayed) {
		
		if (this.startTime > ((DelayedObject) delayed).startTime) {
			return 1;
		} else if (this.startTime < ((DelayedObject) delayed).startTime) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff =  startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MICROSECONDS);
	}

	@Override
	public String toString() {
		return "DelayedObject [startTime=" + startTime + ", name=" + name + "]"+System.currentTimeMillis();
	}
	
	
	

}
