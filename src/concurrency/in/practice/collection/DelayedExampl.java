package concurrency.in.practice.collection;

import java.util.concurrent.DelayQueue;

public class DelayedExampl {
	
	public static void main(String[] args) throws InterruptedException {
		
		DelayQueue<DelayedObject> queue = new DelayQueue<>();
		
//		DelayedObject object1 =  new DelayedObject(2000, "by 2 secounds");
//		DelayedObject object2 =  new DelayedObject(4000, "by 4 secounds");
//		DelayedObject object3 =  new DelayedObject(6000, "by 6 secounds");
//		DelayedObject object4 =  new DelayedObject(8000, "by 8 secounds");
		DelayedObject object5 =  new DelayedObject(10000, "by 10 secounds");
		
		
		
//		queue.put(object1);
//		queue.put(object2);
//		queue.put(object3);
//		queue.put(object4);
		queue.put(object5);
		
		
		while (!queue.isEmpty()) {
			System.out.println(queue.take());
		}
		
		
		
		
		
	}

}
