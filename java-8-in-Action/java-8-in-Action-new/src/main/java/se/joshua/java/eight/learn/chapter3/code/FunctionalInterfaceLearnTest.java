package se.joshua.java.eight.learn.chapter3.code;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class FunctionalInterfaceLearnTest {


    public static int twoArgOperation(int i , int j , FunctionInterfaceLearn<Integer> integerFunctionInterfaceLearn){

       return integerFunctionInterfaceLearn.twoArg(i , j);
    }

    public static void main(String[] args) {

        System.out.println(twoArgOperation(1, 2, (Integer i, Integer j) -> i + j));
        System.out.println(twoArgOperation(5, 4, (Integer i, Integer j) -> i * j));
        System.out.println(twoArgOperation(4, 2, (Integer i, Integer j) -> i % j));
    }
}
