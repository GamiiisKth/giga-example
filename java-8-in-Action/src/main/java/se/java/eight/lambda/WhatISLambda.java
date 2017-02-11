package se.java.eight.lambda;

import sun.util.locale.LocaleMatcher;

import java.util.ArrayList;
import java.util.List;

import static java.util.Locale.filter;
import static se.java.eight.lambda.Apple.filterApplesByPassedPredicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class WhatISLambda {

    // The word predicate is often used in mathematics to mean something function-
    // like that takes a value for an argument and returns true or false
    public static void main(String[] args) {
        Apple a1 = new Apple("green", 100, 1);
        Apple a2 = new Apple("red", 130, 2);
        Apple a3 = new Apple("green", 160, 3);
        Apple a4 = new Apple("green", 200, 4);

        List<Apple> inventory = new ArrayList<>();

        inventory.add(a1);
        inventory.add(a2);
        inventory.add(a3);
        inventory.add(a4);

        // From passing methods to lambdas

        /**
         * Passing methods as values is clearly useful, but it’s a bit annoying having to write a definition for
         * short methods such as isHeavyApple and isGreenApple when they’re used perhaps only once or twice.
         * But Java 8 has solved this too. It introduces a new notation (anonymous functions, or lambdas) that enables you to write just
         */

        System.out.println("filter 1");
        filterApplesByPassedPredicate(inventory, (Apple a) -> "green".equals(a.getColor())).forEach(System.out::println);

        System.out.println("filter 2");
        filterApplesByPassedPredicate(inventory, (Apple a) -> a.getWeight() > 150).forEach(System.out::println);

        System.out.println("filter 3");
        filterApplesByPassedPredicate(inventory, (Apple a) -> a.getWeight() < 100 || a.getColor().equals("red")).forEach(System.out::println);


        /**
         * There is even a standard java filter method which is generic
         */
    }


}
