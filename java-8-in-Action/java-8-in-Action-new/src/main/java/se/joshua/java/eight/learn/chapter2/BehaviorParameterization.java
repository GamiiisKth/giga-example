package se.joshua.java.eight.learn.chapter2;

import se.joshua.java.eight.learn.chap1.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class BehaviorParameterization {

    /**
     * Let’s step back and find a better level of abstraction. One possible solution is to model your selection
     * criteria: you’re working with apples and returning a boolean based on some attributes of Apple (for example, is it green?
     * is it heavier than 150 g?). We call this a predicate (that is, a function that returns a boolean). Let’s therefore define
     * an interface to model the selection criteria:
     * <p>
     * see the class ApplePredicate
     * Look on ApplePredicate.png
     */

    // based on requirement we will inject the one of those implementation to ApplePredicate interface
    // this is what's it called for strategy pattern

    public class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals("green");
        }
    }


    /**
     * ########## The method here it's very cool based
     * <p>
     * we can send any ApplePredicate that we have created maybe AppleRedColorPredicate
     * this is what is called for sending different ''strategy'' as argument
     */

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }



        return result;
    }
    // ****************************BUT THE BEST Solution should be if we have Generic filter

    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        if (inventory.size()==0){
            return null;
        }
        List<T> result = new ArrayList<T>();
        for (T t : inventory) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    //****************************And now we can use lambda to send method as argument to Predicate

    public static void main(String[] args) {
        filter(Collections.emptyList(), (Apple apple) -> apple.getColor().equals("red"));
        filter(Collections.emptyList(), (Integer number) -> number % 2 == 0);


    }
}
