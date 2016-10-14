package se.java.exception;


/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *
 * to learn more
 * http://www.studytonight.com/java/try-and-catch-block.php
 */
public class UnreachableException {

    public static void main(String[] args) {
        nestedException();
        unreachable();

    }


    private static void unreachable(){
        try {
            int arr[] = {1, 2};
            arr[2] = 3 / 0;
        } catch (Exception e)    //This block handles all Exception
        {
            System.out.println("Generic exception");
        }

        //ArrayIndexOutOfBoundsException all other exception under Exception will not execute
    }


    private static void nestedException() {

        try {
            int arr[] = {5, 0, 1, 2};
            try {
                int x = arr[3] / arr[1];
            } catch (ArithmeticException ae) {
                System.out.println("divide by zero");
            }
            arr[4] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array index out of bound exception");
        }

    }


}
