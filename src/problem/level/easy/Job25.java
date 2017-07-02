package problem.level.easy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Job25 implements Callable<Integer> {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		FutureTask<Integer> future = (FutureTask<Integer>) executorService.submit(new Job25());

	}
	
	@Override
	public Integer call() throws Exception {
	
		int i = 3/0;
		
		return null;
	}



}
