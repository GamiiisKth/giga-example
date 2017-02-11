package se.joshua.guava.concurrency;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ListenableFutureSample {



    public static void main(String[] args) {
        FutureCallbackImpl callback = new FutureCallbackImpl();

        callback.setNumber(1000);

        Futures.addCallback(callback.listenableFuture, callback);

    }

    private static class FutureCallbackImpl implements FutureCallback<Integer> {

        StringBuilder builder = new StringBuilder();

        private  int number;
        private static int fibonacciResult;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        @Override
        public void onSuccess(Integer result) {
            builder.append("successfully getting the fibonacci value=" + String.valueOf(result));
        }

        @Override
        public void onFailure(Throwable t) {
            builder.append(t.toString());

        }

        public String getCallBackResult() {
            return builder.toString();
        }


        ListenableFuture<Integer> listenableFuture = listeningExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                return fibonacciResult;
            }
        });

        public FutureCallbackImpl() {
       listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    if (number == 1 || number == 2) {
                        fibonacciResult = 1;
                    }
                    int fibo1 = 1, fibo2 = 1, fibonacci = 1;
                    for (int i = 3; i <= number; i++) {
                        fibonacci = fibo1 + fibo2; // Fibonacci number is sum of previous two Fibonacci number
                        fibo1 = fibo2;
                        fibo2 = fibonacci;
                    }
                    fibonacciResult = fibonacci; // Fibonacci number

                }
            }, executorService);
        }


        public void setNumber(int number) {
            this.number = number;
        }
    }


}