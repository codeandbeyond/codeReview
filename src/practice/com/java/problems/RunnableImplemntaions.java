package practice.com.java.problems;

public class RunnableImplemntaions implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new RunnableImplemntaions();
		runnable.run();
		Thread t = new Thread(runnable);
		System.out.println(t.getState());
		t.start();
		t.join();
		System.out.println(t.getName());
		System.out.println(t.getId());
		
		t.setPriority(2);
		System.out.println(t.getPriority());
		System.out.println(t.getState());
		System.out.println(t.getThreadGroup());
		System.out.println(t.getClass());
		System.out.println(t.getState());
		
	}

	@Override
	public void run() {
		System.out.println(" i am called");

	}
}
