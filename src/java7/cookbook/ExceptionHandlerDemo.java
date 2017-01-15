package java7.cookbook;

public class ExceptionHandlerDemo {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Integer integer = Integer.parseInt("Java");
				
				System.out.println(integer);
				
				
			}
		});
		
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
