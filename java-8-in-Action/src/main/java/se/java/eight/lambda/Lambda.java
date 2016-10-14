package se.java.eight.lambda;

import se.java.eight.parameterization.Apple;

import java.util.Comparator;

/**
 * @author Ali Yusha <mailto:Ali-yusha.hasan@konsult.folksam.se/>
 *         <p>
 *         this  class will show the idea behind the Lambda expression, the case of how to use it
 */
public class Lambda {


    /**
     * Thread class has implemented Runnable interface with run method
     * by using ()->  you just point to run method to be execute the System.out.println();
     * <p>
     * we can sending other task as method argument
     * <p>
     * Thread thread = new Thread(() -> System.out.println("hello lambda"));
     */


    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println("hello lambda"));

        thread.start();

        Runnable r1 = () -> System.out.println("Using lambda"); // using lambda

        Runnable r2 = new Runnable() {  // using anonymous class
            @Override
            public void run() {
                System.out.println("anonymous class ");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("print hello world with lambda passing directly  "));
//*****************************************************************
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };

        // instead of above method we can use lambda

        // int compare(T o1, T o2);

        Comparator<Apple> byWeightLambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> byWeightLambda2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    }


    public static void process(Runnable runnable) {
        runnable.run();
    }

}
