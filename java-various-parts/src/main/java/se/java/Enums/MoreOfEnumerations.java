package se.java.Enums;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         <p>
 *         <p>
 *         Points to remember about Enumerations
 *         <p>
 *         Enumerations are of class type, and have all the capabilities that a Java class has.
 *         Enumerations can have Constructors, instance Variables, methods and can even implement Interfaces.
 *         Enumerations are not instantiated using new keyword.
 *         All Enumerations by default inherit java.lang.Enum class
 */
public enum MoreOfEnumerations {

    // we need constructor
    John(11), Bella(10), Sam(13), Viraaj(9);

    int age;

    MoreOfEnumerations(int age) {

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private static class EnumDemo {
        public static void main(String args[]) {
            MoreOfEnumerations S;
            System.out.println("Age of Viraaj is " + MoreOfEnumerations.Viraaj.getAge() + "years");
        }

    }
}
