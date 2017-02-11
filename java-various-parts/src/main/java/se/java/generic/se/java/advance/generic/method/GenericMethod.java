package se.java.generic.se.java.advance.generic.method;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class GenericMethod {
    // The isIn() method determines if an object is a member of an array.

    private static <T extends Comparable<T>, V extends T> boolean isIn(T t, V[] v) {

        for (V i : v) {
            if (t.equals(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Use isIn() on Integers.
        Integer nums[] = {1, 2, 3, 4, 5};
        if (isIn(2, nums)) {
            System.out.println("2 is in nums");
        }

        // Use isIn() on Strings.
        String strs[] = {"one", "two", "three",
                "four", "five"};
        if (isIn("two", strs))
            System.out.println("two is in strs");
    }
}
