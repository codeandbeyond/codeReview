package practice.com.java.problems;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue sharedqueue;

	public Consumer(BlockingQueue sharedqueue) {
		this.sharedqueue = sharedqueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumer Consumed" + sharedqueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
