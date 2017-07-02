package concurrency.in.practice.factory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory  implements ThreadFactory{

	private int counter;
	private String name;
	private Set<String> log = new HashSet<>();
	
	public MyThreadFactory(String name) {
		this.name = name;
	}

	@Override
	public Thread newThread(Runnable r) {
		counter++;
		return new Thread(r,"C");
	}

}
