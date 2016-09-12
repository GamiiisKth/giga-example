package se.java.generic;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         public class A { }
 *         public class B extends A { }
 *         public class C extends A { }
 */
public class GerericA {

    //Wildcards http://tutorials.jenkov.com/java-generics/wildcards.html


    /**
     * List<?>           listUknown = new ArrayList<A>();
     * List<? extends A> listUknown = new ArrayList<A>();
     * List<? super   A> listUknown = new ArrayList<A>();
     */

    public static final GerericA ONE = GerericA.valueOf("one");
    public static final GerericA TWO = GerericA.valueOf("two");
    public static final GerericA THREE = GerericA.valueOf("three");
    public static final GerericA FOUR = GerericA.valueOf("four");
    public static final GerericA FIVE = GerericA.valueOf("five");
    public static final GerericA SIX = GerericA.valueOf("six");
    public static final GerericA SEVEN = GerericA.valueOf("seven");
    public static final GerericA EIGHT = GerericA.valueOf("eight");

    public static final GerericA[] JACKPOT_IDS = {ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT};

    private String id;

    public GerericA(String name) {
        this.id = name;
    }

    public static GerericA valueOf(final String name) {
        return new GerericA(name);
    }

    @Override
    public String toString() {
        return "GerericA{" +
                "id='" + id + '\'' +
                '}';
    }
}
