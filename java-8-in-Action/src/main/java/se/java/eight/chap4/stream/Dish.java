package se.java.eight.chap4.stream;

import se.java.eight.Type;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         <p>
 *         But streams are about expressing computations such as filter, sorted, and map.gst
 *         Data processing operations— Streams support database-like operations and common operations from
 *         functional programming languages to manipulate data, such as filter, map, reduce, find, match, sort, and so on
 *         . Stream operations can be executed either sequentially or in parallel.
 *         page 105
 */

//   where a Dish is an immutable class defined as

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }
}
