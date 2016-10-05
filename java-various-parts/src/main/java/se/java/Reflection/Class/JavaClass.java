package se.java.Reflection.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         read readme.txt
 */
public class JavaClass {

    private int i0;
    private int i1;
    private int i2;

    public JavaClass() {
    }

    public JavaClass(int i0, int i1, int i2) {
        this.i0 = i0;
        this.i1 = i1;
        this.i2 = i2;
    }


    private static class JavaClassTest {

        public static void main(String... args) {
            try {
                Class<?> cArg = Class.forName("se.java.Reflection.Class.JavaClass");

                Class<?> c = Class.forName("se.java.Reflection.Class.JavaClass");
                Constructor[] allConstructors = c.getDeclaredConstructors();
                for (Constructor ctor : allConstructors) {
                    System.out.println(ctor);

                    Type[] types = ctor.getParameterTypes();

                    for (Type type : types) {
                        System.out.println(type);
                    }
                }


                // production code should handle this exception more gracefully
            } catch (ClassNotFoundException x) {
                x.printStackTrace();
            }
        }

    }
}
