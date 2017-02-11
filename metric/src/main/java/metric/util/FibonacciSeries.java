package metric.util;


import com.codahale.metrics.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class FibonacciSeries {

    private FibonacciSeriesMetric fibonacciSeries;

    private MetricRegistry metricRegistry = SharedMetricRegistries.getOrCreate("fibonacciSeries-metrics");
    private Meter producerMeter = metricRegistry.meter("producerMeter");
    private Meter consumerMeter = metricRegistry.meter("consumerMeter");
    private Counter pendingJobs = metricRegistry.counter(name("pendingJobs"));


    private FibonacciSeriesMetric fibonacciSeriesMetric;


    private List<Integer> integerList = new ArrayList();
    private List<Integer> primeNumbers = new ArrayList();

    private BlockingQueue<Integer> isPrimeExecutingQueue = new ArrayBlockingQueue<Integer>(10); // are thread-safe

    public void setIntegerList(ArrayList integerList) {
        this.integerList = integerList;
    }


    public FibonacciSeries() {
    }

    private FibonacciSeries(Builder builder) {
        this.producerMeter = builder.producerMeter;
        this.consumerMeter = builder.consumerMeter;
        this.pendingJobs = builder.pendingJobs;
        this.metricRegistry = builder.metricRegistry;
        this.fibonacciSeriesMetric = builder.fibonacciSeriesMetric;


    }


    public void executeFibonacciLoop() {

    }


    //checks whether an int is prime or not.
    private boolean isPrime(int n) throws ArithmeticException {

        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    Runnable primeTask = () -> {
        int prime;
        while (true) {
            try {
                prime = isPrimeExecutingQueue.take();

                consumerMeter.mark();
                pendingJobs.dec();

                if (isPrime(prime)) {
                    primeNumbers.add(prime);

                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };


    Runnable fibonacciLoopTask = () -> {
        int size = integerList.size();
        size = size - 1;
        while (size >1) {


            producerMeter.mark();
            pendingJobs.inc();

            int number = integerList.get(size);

            if (number == 1 || number == 2) {
                isPrimeExecutingQueue.add(1);
                System.out.println(number);
            }
            int fibo1 = 1, fibo2 = 1, fibonacci = 1;
            for (int i = 3; i <= number; i++) {
                fibonacci = fibo1 + fibo2; // Fibonacci number is sum of previous two Fibonacci number
                fibo1 = fibo2;
                fibo2 = fibonacci;

            }
            try {
                isPrimeExecutingQueue.put(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            size--;
        }



    };

    void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    void wait5Seconds() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Meter producerMeter;
        private Counter pendingJobs;
        private MetricRegistry metricRegistry;
        private FibonacciSeriesMetric fibonacciSeriesMetric;
        private Meter consumerMeter;


        public Builder() {
        }

        public Builder(Meter meter, Meter consumerMeter, Counter pendingJobs, MetricRegistry metricRegistry) {
            this.producerMeter = meter;
            this.consumerMeter = consumerMeter;
            this.pendingJobs = pendingJobs;
            this.metricRegistry = metricRegistry;

        }

        public Builder withMeter(Meter meter) {
            this.producerMeter = meter;
            return this;
        }

        public Builder withCounter(Counter pendingJobs) {
            this.pendingJobs = pendingJobs;
            return this;
        }

        public Builder withFibonacciSeriesMetric(FibonacciSeriesMetric fibonacciSeriesMetric) {
            this.fibonacciSeriesMetric = fibonacciSeriesMetric;
            return this;
        }

        public Builder withProducerMeter(MetricRegistry metricRegistry) {
            this.metricRegistry = metricRegistry;
            return this;
        }

        public Builder withConsumerMeter(MetricRegistry metricRegistry) {
            this.metricRegistry = metricRegistry;
            return this;
        }

        public FibonacciSeries build() {
            return new FibonacciSeries(this);

        }

    }

}
