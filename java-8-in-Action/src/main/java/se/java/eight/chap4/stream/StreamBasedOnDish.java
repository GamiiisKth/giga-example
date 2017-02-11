package se.java.eight.chap4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import se.java.eight.Type;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         page 104
 */
public class StreamBasedOnDish {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH));


    private static void filterByStream() {
        List<Dish> isVegeterians = menu.stream().filter(Dish::isVegetarian).
                collect(Collectors.toList());

        System.out.println("filterByStream");
        systemOutPutOfList(isVegeterians);

    }

    private static void filterMapLimit() {
        List<String> threeHeightCaloricDishName = menu.
                stream().filter(dish -> dish.getCalories() > 300).
                map(Dish::getName).
                limit(3).
                collect(Collectors.toList());

        System.out.println("\nthreeHeightCaloricDishName");
        systemOutPutOfList(threeHeightCaloricDishName);
    }

    public static void main(String[] args) {

        filterByStream();
        filterMapLimit();

    }


    private static void systemOutPutOfList(List<?> e) {
        e.forEach(System.out::println);
        threeHeightCaloricDishName.forEach( System.out::println);

        System.out.println("out during operation");

        /**
         * page 114 you can do other operation during filter , map limit operation
         */

    }
}
