package se.java.thread;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         http://www.studytonight.com/java/creating-a-thread.php
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
