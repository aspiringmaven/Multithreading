package problem.level.easy;

public class ThreadStart {

	public ThreadStart() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Jobb());
		thread.start();
		thread.join();
		thread.start();
	}
	

}

class Jobb implements Runnable {

	@Override
	public void run() {
		System.out.println("Running");
	}
	
}
