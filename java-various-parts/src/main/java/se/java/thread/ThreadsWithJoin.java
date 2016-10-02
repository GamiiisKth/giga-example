package se.java.thread;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */


/**
 * Before your start whit this code you should start from WhitOutJoin class
 * <p>
 * Threads start running.....Thread-0
 * Threads start running.....Thread-1
 * Thread-1 is complete
 * Thread-0 is complete
 * <p>
 * the output is from ThreadsWhitOutJoin -> the problem is the order
 * we should have this order of execution
 * <p>
 * Threads start running.....Thread-0
 * Thread-1 is complete
 * Threads start running.....Thread-1
 * Thread-0 is complete
 * <p>
 * <p>
 * the problem become when the threads doesn't wait for each other
 * <p>
 * <p>
 * we will resolve this problem with Join()
 */
public class ThreadsWithJoin {


    public static void main(String[] args) {

       // withOutSpecifyingJoinTime();

        // by sending the join time the current execute thread will become Interrupted by waiting thread for run

        System.out.println("*******time*******");

        withSpecifyingJoinTime(600);
    }

    private static void withOutSpecifyingJoinTime() {
        ThreadsUsingJoin usingJoin1 = new ThreadsUsingJoin();
        ThreadsUsingJoin usingJoin2 = new ThreadsUsingJoin();

        usingJoin1.start();
        try {
            usingJoin1.join();
        } catch (InterruptedException e) {
            System.out.println("Exception = " + e);
        }

        usingJoin2.start();
    }

    private static void withSpecifyingJoinTime(int time) {
        ThreadsUsingJoin usingJoin1 = new ThreadsUsingJoin();
        ThreadsUsingJoin usingJoin2 = new ThreadsUsingJoin();

        usingJoin1.start();
        try {
            usingJoin1.join(time);
        } catch (InterruptedException e) {
            System.out.println("Exception = " + e);
        }

        usingJoin2.start();
    }

    /**
     *
     */
    private static class ThreadsUsingJoin extends Thread {

        @Override
        public void run() {

            System.out.println("Threads start running....." + Thread.currentThread().getName());

            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {

                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " is complete");


        }
    }


}
