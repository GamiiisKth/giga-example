package se.java.threadlocal;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ThreadLocalTest {
//The ThreadLocal class in Java enables you to ***create variables that can only be read and written by the same thread****
    //Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal variable,
    // then the two threads cannot see each other's ThreadLocal variables


    /**
     * As you can see, you instantiate a new ThreadLocal object. This only needs to be done once per thread.
     * Even if different threads execute the same code which accesses a ThreadLococal, each thread will see
     * only its own ThreadLocal instance. Even if two different threads set different values on the same ThreadLocal object,
     * they cannot see each other's values.
     */
    private static ThreadLocal<Integer> threadLocalOne = new ThreadLocal<Integer>();



    static Runnable runnable = () -> {

        threadLocalOne.set((int) (Math.random() * 100D));

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocalOne.get());
    };

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(runnable);
        Thread thread2= new Thread(runnable);
        thread1.start();
        thread2.start();

        // main thread will wait to thread1 exit
        thread1.join();

        // main thread will wait to thread2 exit
        thread2.join();

        // main thread  will exit
    }

}
