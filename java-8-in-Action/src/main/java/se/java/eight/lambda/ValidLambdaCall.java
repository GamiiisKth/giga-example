package se.java.eight.lambda;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         To understand more about lamda look at oneNote -> java8 -> lamda
 */
public class ValidLambdaCall {

    /**
     * FunctionalInterface can't inherit from any other interface , only one
     */
    @FunctionalInterface
    private interface Math {
        int mathCombine(int b, int a);
    }

    public static void main(String[] args) {

        //************************* execute() **************************************
        // this is a valid because of ()->{} no parameter () and return is {}
        execute(() -> {
        });

        Runnable runnable = () -> System.out.println("hello valid");
        execute(runnable);
        execute(() -> System.out.println("hello"));
        //***************************************************************

        //***************************************************************

        System.out.println("Math interface ");
        // statements
        Math minus = (int a, int b) -> {return a - b;};

        // expression
        Math mutlti = (int a, int b) -> a * b;
        Math add = (int a, int b) -> a + b;

        System.out.println(mutlti.mathCombine(10, 10));
        System.out.println(add.mathCombine(10, 10));
        System.out.println(minus.mathCombine(10, 10));

        //***************************************************************

    }

    private static void execute(Runnable runnable) {
        runnable.run();
    }

}
