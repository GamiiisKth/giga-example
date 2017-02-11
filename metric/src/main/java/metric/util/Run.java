package metric.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class Run {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("fibonacciSeries-metric.xml");

        FibonacciSeries fibonacciSeries = (FibonacciSeries) context.getBean("fibonacciSeries");

        ArrayList list  = new ArrayList();
        for (int i = 1;i <10000000; i++  ){
            list.add(i);

        }
        fibonacciSeries.setIntegerList(list);
        fibonacciSeries.startReport();

        Thread prime = new Thread(fibonacciSeries.primeTask);
        Thread fibonacci = new Thread(fibonacciSeries.fibonacciLoopTask);
        fibonacci.start();

        try {
            prime.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prime.start();

        fibonacciSeries.wait5Seconds();



    }
}
