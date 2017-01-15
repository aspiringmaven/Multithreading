package java7.cookbook;

public class MyThreadGroup extends ThreadGroup{

	public MyThreadGroup(String name) {
		super(name);
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.ThreadGroup#uncaughtException(java.lang.Thread, java.lang.Throwable)
	 * Another way to handle Exception
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		super.uncaughtException(t, e);
	}
}
