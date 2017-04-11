package com.java.problems;

/**
 * Created by apatra on 20/02/17.
 */
public class TestThread {
    private static int regdNo;
    private  int reNo;
    public static void main(String[] args)  {

        TestThread tt=new TestThread();
        TestThread tt2=new TestThread();
        System.out.println(" "+regdNo+" "+tt.reNo);
        tt2.reNo=6;
        TestThread.regdNo=10;
        System.out.println(" "+regdNo+" "+tt.reNo);
        System.out.println(" "+regdNo+" "+tt2.reNo);
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
        try {
            t1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

        //start second thread after waiting for 2 seconds or if it's dead
        try {
            t1.join(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        //start third thread only when first thread is dead
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();

        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("All threads are dead, exiting main thread");
    }
    public int getMe(){
        System.out.println(" "+regdNo+" "+reNo);
        return 0;
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started:::" + Thread.currentThread().getName());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::" + Thread.currentThread().getName());
    }

}

