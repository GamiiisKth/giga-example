package se.java.generic.se.java.advance.generic.Wildcards;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class BoundedWildcards {


    protected static class TwoDim {
        public int x, y;

        public TwoDim(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    protected static class ThreeDim extends TwoDim {
        public int z;

        public ThreeDim(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

    }

    protected static class FourDim extends ThreeDim {
        public int t;

        public FourDim(int x, int y, int z, int t) {
            super(x, y, z);
            this.t = t;
        }
    }

    // This class holds an array of coordinate objects.
    protected class Coords<T extends TwoDim> {
        T[] coords;

        Coords(T[] o) {
            coords = o;
        }
    }

    // Demonstrate a bounded wildcard.
    static class BoundedWildcard {
        static void showXY(Coords<?> c) {
            System.out.println("X Y Coordinates:");
            for (int i = 0; i < c.coords.length; i++)
                System.out.println(c.coords[i].x + " " + c.coords[i].y);
            System.out.println();
        }

        static void showXYZ(Coords<? extends ThreeDim> c) {
            System.out.println("X Y Z Coordinates:");
            for (int i = 0; i < c.coords.length; i++)
                System.out.println(c.coords[i].x + " " + c.coords[i].y + "" + c.coords[i].z);
            System.out.println();
        }

        static void showAll(Coords<? extends FourDim> c) {
            System.out.println("X Y Z T Coordinates:");

                        for (int i = 0; i < c.coords.length; i++)

                                System.out.println(
                                c.coords[i].x + " " +
                                c.coords[i].y + " " +
                                c.coords[i].z + " " +
                                c.coords[i].t);

                        System.out.println();

        }

    }


}
