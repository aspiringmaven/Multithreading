package problem.level.easy;

public class DeamonThread {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Job2(10));
		t.setName("Dude");		
		
		Thread deamon = new Thread(new Job2(100));
		deamon.setName("Deamon");
		deamon.setDaemon(true);		
		
		t.start();
		deamon.start();
		
	}	
}


class Job2 implements Runnable {
	
	private volatile int end;
		
	public Job2(int end) {
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=0;i<end;i++){
			System.out.println(Thread.currentThread().getName()+""+i);
			if(Thread.currentThread().isDaemon()){
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}	
}
