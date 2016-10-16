package se.java.eight.chap3.common.lambda.function.function;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         page 88
 *        But you need a functional interface that will match the signature of that constructor reference.
 *        Because there isn’t one in the functional interface starter set, you can create your own:
 *
 *        TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;

}
 */
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);

}
