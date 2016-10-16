package se.java.eight.chap3.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple() {
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(Builder builder) {
        this.weight = builder.weight;
        this.color = builder.color;
    }



    public static Builder builder() {
        return new Builder();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }


    public static class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            String name = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + name + " " + apple.getColor() + " apple";
        }
    }

    public static class AppleSimpleFormatter implements AppleFormatter {

        @Override
        public String accept(Apple apple) {

            return "An apple of " + apple.getWeight() + "g";
        }
    }


    public static void prettyPrintApple(List<Apple> apples, final AppleFormatter formatter) {

        for (Apple apple : apples) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String... args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        prettyPrintApple(inventory, new AppleSimpleFormatter());

        System.out.println("---AppleFancyFormatter----");

        prettyPrintApple(inventory, new AppleFancyFormatter());
    }

    public static class Builder {
        private int weight = 0;
        private String color = "";

        public Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }


        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Apple build(){
            return new Apple(this);
        }

    }

}