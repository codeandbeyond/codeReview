package practice.com.java.problems;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue sharedqueue = new LinkedBlockingQueue();
		Thread prodThread = new Thread(new Producer(sharedqueue));
		Thread consThread = new Thread(new Consumer(sharedqueue));
		prodThread.start();
		consThread.start();
	}
}
