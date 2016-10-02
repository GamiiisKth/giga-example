package se.java.thread;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         http://www.studytonight.com/java/joining-a-thread.php
 *         <p>
 *         The isAlive() method returns true if the thread upon which it is called is still running otherwise it returns false.
 *         <p>
 *         But, join() method is used more commonly than isAlive(). This method waits until the thread on which it is called terminates.
 */
public class ThreadsWhiteoutJoin {


    public static void main(String[] args) {

        //isAliveTestWithIsAliveMethod();
        isAliveTestWithOutIsAliveMethod();
    }

    private static class IsThreadAlvie extends Thread {

        @Override
        public void run() {

            System.out.println("Threads start running....." + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
                /**
                 * ##########################important point#########################
                 *
                 *  if any thread has interrupted the current thread. The
                 *  <i>interrupted status</i> of the current thread is
                 *
                 *   threadAlvie2 will interrupted the threadAlvie1 that because why we need to use
                 *   Join() that thread need to wait on each other
                 */
            } catch (InterruptedException e) {

                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " is complete");

        }

    }



    private static void isAliveTestWithIsAliveMethod(){
        IsThreadAlvie threadAlvie1 = new IsThreadAlvie();
        IsThreadAlvie threadAlvie2 = new IsThreadAlvie();

        threadAlvie1.start();
        threadAlvie2.start();
        System.out.println(threadAlvie1.isAlive());


        System.out.println(threadAlvie2.isAlive());

    }
    private static void isAliveTestWithOutIsAliveMethod(){
        IsThreadAlvie threadAlvie1 = new IsThreadAlvie();
        IsThreadAlvie threadAlvie2 = new IsThreadAlvie();

        threadAlvie1.start();
        threadAlvie2.start();

    }
}
