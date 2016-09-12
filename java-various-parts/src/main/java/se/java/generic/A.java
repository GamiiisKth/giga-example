package se.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }

    public static final A ONE = A.valueOf("one");
    public static final A TWO = A.valueOf("two");
    public static final A THREE = A.valueOf("three");
    public static final A FOUR = A.valueOf("four");
    public static final A FIVE = A.valueOf("five");
    public static final A SIX = A.valueOf("six");
    public static final A SEVEN = A.valueOf("seven");
    public static final A EIGHT = A.valueOf("eight");

    public static final A[] JACKPOT_IDS = {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT};


    public static A valueOf(final String name) {
        return new A(name);
    }


    private static class B extends A {
        private int i;

        public B(String name, int i) {
            super(name);
            this.i = i;
        }
    }

    private static class C extends A {
        public C(String name) {
            super(name);
        }
    }

    // D extends from A but transitive hence D extends C extends A
    private static class D extends C {
        public D(String name) {
            super(name);
        }
    }

    /**
     * List<?>           listUknown = new ArrayList<A>();
     * List<? extends A> listUknown = new ArrayList<A>();
     * List<? super   A> listUknown = new ArrayList<A>();
     */

    private static List<A> listA;
    private static List<B> listB;
    private static List<C> listC;
    private static List<D> listD;
    static List<Object> objects = new ArrayList<>();

    public static void wildcardBoundaryExtendsRunner() {
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        listC = new ArrayList<>();
        listD = new ArrayList<>();


        int lenght = A.JACKPOT_IDS.length;
        while (lenght > 0) {
            listA.add(A.JACKPOT_IDS[lenght & 7]);
            listA.add(B.JACKPOT_IDS[lenght & 7]);
            listA.add(C.JACKPOT_IDS[lenght & 7]);
            listA.add(D.JACKPOT_IDS[lenght & 7]);
            objects.add(D.JACKPOT_IDS[lenght & 7]);
            lenght--;
        }
        wildcardBoundaryExtends(listA);
        wildcardBoundaryExtends(listB);
        wildcardBoundaryExtends(listC);
        wildcardBoundaryExtends(listD);

        //You can now call insertElements() with either a List<A>, or a List typed to a superclass of A which is Object.
        // Thus, this example is now valid:
        insertElements(listA, listA.getClass().getName());
        insertElements(objects, objects.getClass().getName());


    }

    /*
    Upper_bounded Wildcards
    List<? extends A> means a List of objects that are instances of the class A, or subclasses of A (e.g. B and C).
    ---
    Unbounded List<?>
     */
    private static void wildcardBoundaryExtends(List<? extends A> as) {
        for (A a : as) {
            System.out.println(a.toString() + A.class.getName());
        }
    }

    /*
        Lower_bounded Wildcards
    When you know that the list is typed to either A, or a superclass of A , Object
     */
    public static void insertElements(List<? super A> list, String name) {
        /*
        it is safe to insert instances of A or subclasses of A (e.g. B or C) into the list
         */
        list.add(new A(name));
        list.add(new B(name, 1));
        list.add(new C(name));
        list.add(new D(name));

        wildcardBoundaryExtends((List<? extends A>) list);
    }


    public static void main(String[] args) {
        wildcardBoundaryExtendsRunner();

    }

}