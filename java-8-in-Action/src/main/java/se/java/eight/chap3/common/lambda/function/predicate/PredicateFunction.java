package se.java.eight.chap3.common.lambda.function.predicate;

import se.java.eight.chap3.common.Apple;

import java.util.function.Predicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 * So a.or(b).and(c) can be seen as (a || b) && c.
 * page 93
 */
public class PredicateFunction {

    Predicate<Apple> redApple = (Apple a) -> {
        return a.getColor().equals("red");
    };

    Predicate<Apple> appleGreen = redApple.and(apple -> apple.getWeight()> 150);


}
