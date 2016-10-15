package se.java.eight.lambda.function.function;

import se.java.eight.common.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         <p>
 *         oneNote-> java8-> methodReference
 */
public class FunctionFunction {

    /**
     * The java.util.function.Function<T, R> interface defines an abstract method named apply
     * that takes an object of generic type T as input and returns an object of generic type R.
     * <p>
     * The java.util.function.Function<T, R> interface defines an abstract method named apply that
     * takes an object of generic type T as input and returns an object of generic type R.
     */


    //   method map to transform a list of Strings into a list of Integers containing the length of each String.
    // a generic map
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {

        List<R> result = new ArrayList<R>();
        list.forEach(t -> result.add(function.apply(t)));
        return result;
    }

    // The Integer is mapped to Apple constructor with a integer
    Function<Integer, Apple> c2 = Apple::new;
    Apple apple = c2.apply(110);

    /**
     * In the following code, each element of a List of Integers is passed to the constructor
     * of Apple using a similar map method we defined earlier, resulting in a List of apples with different weights:
     */

    List<Integer> weights = Arrays.asList(7, 3, 4, 10);
    List<Apple> apples = map(weights, Apple::new);


    public static void main(String[] args) {
        // test of generic map
        List<Integer> l = map(Arrays.asList("lambda", "test", "hej"), String::length);
        l.forEach(System.out::println);
    }




}
