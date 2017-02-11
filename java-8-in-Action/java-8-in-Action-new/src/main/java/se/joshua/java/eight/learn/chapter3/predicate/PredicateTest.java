package se.joshua.java.eight.learn.chapter3.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class PredicateTest {


    public static void main(String[] args) {

        List<Double> values = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            double random = (double) (Math.random() + 1) * 100;
            values.add(random);
        }

        Predicate<Double> predicate = (Double i) -> i > 170.0;

        List<Double> result = filter(values, predicate);
        List<Double> result2 = filter(values, (Double d) -> d > 188.0);

        result.forEach(System.out::println);
        System.out.println("result 2 ");
        result2.forEach(System.out::println);
    }


    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();

        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
