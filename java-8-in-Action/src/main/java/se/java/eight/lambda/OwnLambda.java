package se.java.eight.lambda;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class OwnLambda {

    @FunctionalInterface
    public interface Converter<K, V> {
        V convert(K from);
    }


    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;

        System.out.printf(String.valueOf(converter.convert("123")));

    }
}
