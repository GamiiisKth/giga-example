package se.so4it.learn.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class JAVA8 {


    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");
        names.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //   eval(list, n -> n > 3);
        eval(list, n -> n % 2 == 0);

    }

    /**
     * http://www.tutorialspoint.com/java8/java8_functional_interfaces.htm
     * <p>
     * we can use the method to compare to object be sending the predicate as parameter
     *
     * @param list
     * @param predicate should contain integer in  this situation
     *                  but by changing the <Integer> to <?> instead can we compare any type
     *                  //TODO remember to implement the rest of code a.s.a.p
     */
    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }


}
