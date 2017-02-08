package practice.com.java.problems;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue sharedqueue;

	public Producer(BlockingQueue sharedqueue) {
		this.sharedqueue = sharedqueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Producer produced:" + i);
				sharedqueue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
