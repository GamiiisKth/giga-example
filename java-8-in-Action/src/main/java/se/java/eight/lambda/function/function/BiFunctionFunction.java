package se.java.eight.lambda.function.function;

import se.java.eight.common.Apple;

import java.util.function.BiFunction;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class BiFunctionFunction {

    public static void main(String[] args) {

        BiFunction<Integer, String, Apple> biFunction = (weight, color) -> new Apple(weight, color);
        Apple apple = biFunction.apply(110, "green");

        System.out.println(apple);

        // other way to create constructor
        BiFunction<Integer, String, Apple> biFunction2 = Apple::new;



    }
}
