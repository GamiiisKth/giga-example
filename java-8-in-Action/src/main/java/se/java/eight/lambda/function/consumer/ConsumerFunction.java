package se.java.eight.lambda.function.consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ConsumerFunction {


    /**
     * The java.util.function.Consumer<T> interface defines an abstract method
     * named accept that takes an object of generic type T and returns no result (void)
     */


    private static List<String> persons= new ArrayList<>();

    public static void main(String[] args) {

        persons.forEach(System.out::println);

    }
}
