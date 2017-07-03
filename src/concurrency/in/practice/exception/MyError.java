package concurrency.in.practice.exception;

public class MyError {

	public static void main(String[] args) {
		
		try {
			new OutOfMemoryError();
			
		} catch (Error e) {
			System.out.println("errror");
		}
		
		System.out.println("Works");
		
	}
}
