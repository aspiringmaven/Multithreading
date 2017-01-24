package concurrency.in.practice.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/*Exchange Data between thread*/
public class App {

	public App() {
		
	}
	
	public static void main(String[] args) {
		Exchanger<Message> exchanger = new Exchanger<Message>();
		new Thread(new Sender(exchanger)).start();
		new Thread(new Receiver(exchanger)).start();
	}

}

class Sender implements Runnable {

	/**
	 * @param exchanger
	 */
	public Sender(Exchanger<Message> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	private final Exchanger<Message> exchanger;
	
	@Override
	public void run() {
		System.out.println("Sender sending...");
		try {
			TimeUnit.SECONDS.sleep(3);
			Message received = exchanger.exchange(new Message("Hello From Sender"));
			
			System.out.println("Sender Received" + received);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

	public Exchanger<Message> getExchanger() {
		return exchanger;
	}
	
}

class Receiver implements Runnable {

	/**
	 * @param exchanger
	 */
	public Receiver(Exchanger<Message> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	private final Exchanger<Message> exchanger;
	
	@Override
	public void run() {
		System.out.println("Receiver sending...");
		try {
			TimeUnit.SECONDS.sleep(9);
			Message received = exchanger.exchange(new Message("Hello From Receiver"));
			
			System.out.println("Receiver Received" + received);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

	public Exchanger<Message> getExchanger() {
		return exchanger;
	}
	
}

class Message {

	/**
	 * @param data
	 */
	public Message(String data) {
		super();
		this.data = data;
	}

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	
}