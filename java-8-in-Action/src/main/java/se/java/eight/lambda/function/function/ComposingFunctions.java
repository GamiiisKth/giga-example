package se.java.eight.lambda.function.function;

import java.util.function.Function;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ComposingFunctions {

//******************************************************************
//Composing Functions
//******************************************************************

    // g(f(x))
    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;
    Function<Integer, Integer> h = f.andThen(g);


    /**
     * This all sounds a bit too abstract. How can you use these in practice?
     * Let’s say you have various utility methods that do text transformation on a letter represented as a String:
     */

    public static class Letter {
        public static String addHeader(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }

        public static String addFooter(String text) {
            return text + " Kind regards";
        }

        public static String checkSpelling(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
    }

}
