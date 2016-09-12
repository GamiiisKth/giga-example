package se.so4it.learn.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @author Ali Yusha {@literal <mailto:ali-yusha.hasan@konslut.folksam.se>}
 */
public abstract class AbstractFunctionalComparable<T extends AbstractFunctionalComparable<T>> implements Comparator<T> {

    public abstract Predicate<T> getFunctional();




    @Override
    public int compare(T o1, T o2) {

        return 0;
    }

    public List<T> eval(List<T> list) {
        Predicate<T> predicate = getFunctional();

        List<T> predicatedList = new ArrayList<T>();
        for (T n : list) {
            if (predicate.test(n)) {
                predicatedList.add(n);
            }
        }
        return predicatedList;
    }


}
