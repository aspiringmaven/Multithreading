/**
 * 
 */
package java7.cookbook;

import java.util.concurrent.ThreadFactory;

/**
 * @author DeLL
 *
 */
public class MyThreadFactory implements ThreadFactory {
	//put maximum limit using Semaphore
	//log stat of creation
	//personal validaton
	
	@Override
	public Thread newThread(Runnable r) {		
		if(r != null) {
			
		}
		return new Thread(r);
	}
}
