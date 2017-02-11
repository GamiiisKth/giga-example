package se.java.eight.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class Apple {

    private String color;
    private int weight;
    private int id;

    public Apple(String color, int weight, int id) {
        this.color = color;
        this.weight = weight;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", id=" + id +
                '}';
    }

    public static boolean isHeavy(Apple a) {
        return a.getWeight() > 150;
    }

    public static boolean isGreen(Apple a) {
        return a.getColor().equals("green");
    }


    public static List<Apple> filterApplesByPassedPredicate(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> filteredApplesByPredicate = new ArrayList<>();

        apples.forEach(apple -> {
            if (predicate.test(apple)) {
                filteredApplesByPredicate.add(apple);
            } else {
                System.out.println(String.format("Apple %s can't pass the predicate condition", apple.getId()));
            }
        });
        return filteredApplesByPredicate;
    }


}
