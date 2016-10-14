package se.java.eight.parameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Ali Yusha <mailto:Ali-yusha.hasan@konsult.folksam.se/>
 */
public class ParameterizationSort {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        inventory.sort((Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));

        inventory.forEach(System.out::println);
    }

    public static List<Apple> sort(List<Apple> apples){
        List<Apple> apples1 = new ArrayList<>();
       Apple apple;
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return  o1.getWeight().compareTo(o2.getWeight());
            }
        });
        return null;
    }





}
