package se.java.threadlocal;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ThreadLocalByInitValueTest {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ThreadOne.runnable);
        Thread thread2 = new Thread(ThreadTwo.runnable);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


    }

    // by create a new instance of this you will get a new instance of threadLocal of typ ThreadContext with generated init value
    private static class ThreadContext extends ThreadLocal<Integer> {

        private int changeInitValue;

        @Override
        public void set(Integer changeInitValue) {
            super.set(changeInitValue);
        }

        private Integer initValue = (int) (Math.random() * 100D);

        @Override
        protected Integer initialValue() {
            return this.initValue;
        }


    }

    private static class ThreadOne {


        static Runnable runnable = () -> {
            ThreadContext threadContext = new ThreadContext();

            System.out.println("ThreadContext of: " + Thread.currentThread().getName() + ", Init value= " + threadContext.get());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadContext.set((int) (Math.random() * 100D));

            System.out.println("ThreadContext of:" + Thread.currentThread().getName() +" ,the value has changed= " + threadContext.get());

        };
    }

    private static class ThreadTwo {

        static Runnable runnable = () -> {
            ThreadContext threadContext = new ThreadContext();
            System.out.println("ThreadContext of:" + Thread.currentThread().getName() + ", Init value= " + threadContext.get());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadContext of:" + Thread.currentThread().getName() + ", the value has changed= " + threadContext.get());
        };
    }


}
