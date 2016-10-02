package se.java.thread;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 * http://www.studytonight.com/java/creating-a-thread.php
 */

/**
 * Difference between implement Runnable and extends Thread class is
 * <p>
 * By implementing Runnable you need to create a instance of thread class
 * to have the access to thread class method
 * <p>
 * but by extending you will directly have access to the method whitOut get a instance of thread class
 */
public class ThreadByImplementRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("concurrent thread started running..");
    }


    public static void main(String[] args) {
        ThreadByImplementRunnable byImplementRunnable = new ThreadByImplementRunnable();

        Thread thread = new Thread(byImplementRunnable);
        thread.start();
    }
}
