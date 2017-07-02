package problem.level.easy;

public class ThreadState {

	public ThreadState() {
	}

	public static void main(String[] args) {
		for(Thread.State state:Thread.State.values()) {
			System.out.println(state);
		}
	}
}
