package se.joshua.guava.concurrency;

import com.google.common.util.concurrent.Monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class MonitorSample {


    private List<String> list = new ArrayList<>();
    private static final int MAZ_SIZE = 10;

    private Monitor monitor = new Monitor();

    //Here our Guard instance returns true when our List instance contains fewer than ten items.
    private Monitor.Guard listBelowCapacity = new Monitor.Guard(monitor) {
        @Override
        public boolean isSatisfied() {
            return list.size() < MAZ_SIZE;
        }
    };

    //Finally in the addToList method, a thread will enter the Monitor and add an item to the list when our
    // Guard condition evaluates to true, otherwise, the thread will wait

    public void addToList(String item) throws InterruptedException {
        // Notice the more readable enterWhen method that will allow a thread to enter the block when the
        //Guard condition is satisfied
        monitor.enterWhen(listBelowCapacity);
        try {
            System.out.println("adding item: " + item);
            list.add(item);
            System.out.println(Thread.currentThread().getName());
        } finally {
            // leave the monitor which allow other thread to enter the monitor block
            monitor.leave();
        }
    }

    //  Only one thread can enter a Monitor block at any time.
// The semantics are the same as using or ReentrantLocks

    public static void main(String[] args) throws InterruptedException {

        MonitorSample monitorSample = new MonitorSample();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    try {
                        monitorSample.addToList(String.valueOf(finalI));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Finished all threads");
        }
    }
}
