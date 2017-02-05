package concurrency.in.practice.executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App4 {

	public App4() {

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		ExecutorService executorService = Executors.newFixedThreadPool(matrix.length);
		
		Set<Callable<Long>> callables = new HashSet<Callable<Long>>();
		for (int index = 0; index < matrix.length; index++)
			callables.add(new Job(matrix, index));
		
		try {
			List<Future<Long>> futures = executorService.invokeAll(callables);
			
			for(Future<Long> rowSum: futures) {
				System.out.println(rowSum.get());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}

class Job implements Callable<Long> {

	private final int matrix[][];
	private final int row;

	/**
	 * @param matrix
	 * @param row
	 */
	public Job(int[][] matrix, int row) {
		super();
		this.matrix = matrix;
		this.row = row;
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int col = 0; col < matrix[row].length; col++) {
			sum += matrix[row][col];
		}
		return sum;
	}

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

}
