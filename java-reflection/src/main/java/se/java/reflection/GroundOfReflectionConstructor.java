package se.java.reflection;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

import se.java.reflection.lablcass.FromClassGetInfoAboutMe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/**
 * Obtaining Constructor Objects
 * Constructor Parameters
 * Instantiating Objects using Constructor Object
 */
public class GroundOfReflectionConstructor {

    // Using Java Reflection you can inspect the constructors of classes and instantiate objects at runtime.

    private static Class aClass = FromClassGetInfoAboutMe.class;

    public static void main(String[] args) {

        Constructor[] constructors = aClass.getConstructors();
        Type[] types;

        for (Constructor constructor1 : constructors) {

            if (constructor1.getGenericParameterTypes().length >= 2) {

                types = constructor1.getParameterTypes();

                for (Type type : types) {
                    System.out.println();

                }
            }

        }
    }


}
