package se.java.eight.lambda;

import java.util.ArrayList;
import java.util.List;

import static se.java.eight.lambda.Apple.filterApplesByPassedPredicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class WhatISPredicate {

    // The word predicate is often used in mathematics to mean something function-
    // like that takes a value for an argument and returns true or false
    public static void main(String[] args) {
        Apple a1 = new Apple("green", 100, 1);
        Apple a2 = new Apple("red", 130, 2);
        Apple a3 = new Apple("green", 160, 3);
        Apple a4 = new Apple("green", 200, 4);

        List<Apple> inventory=new ArrayList<>();

        inventory.add(a1); inventory.add(a2); inventory.add(a3); inventory.add(a4);

        // As you can see we can passing methods as values (Apple::isGreen) what is predicate
        filterApplesByPassedPredicate(inventory,Apple::isGreen).forEach(System.out::println);
        filterApplesByPassedPredicate(inventory,Apple::isHeavy).forEach(System.out::println);
    }


}
