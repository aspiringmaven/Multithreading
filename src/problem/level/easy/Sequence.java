package problem.level.easy;

public class Sequence {
	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0;i<10;i++){
			Thread t = new Thread(new Job("sumit--"+i));
			t.start();
			//t.join();
			while(t.isAlive());
		}		
	}			
}

class Job implements Runnable {
	
	private String name;
	
	public Job(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		System.out.println(this.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}