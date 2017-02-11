package se.java.reflection;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

import se.java.reflection.lablcass.FromClassGetInfoAboutMe;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Using Java Reflection you can inspect Java classes at runtime.
 * Inspecting classes is often the first thing you do when using Reflection.
 * From the classes you can obtain information about
 * <p>
 * <p>
 * Class Name
 * Class Modifies (public, private, synchronized etc.)
 * Package Info
 * Superclass
 * Implemented Interfaces
 * Constructors
 * Methods
 * Fields
 * Annotations
 */
public class GroundOfReflectionClass {

    public GroundOfReflectionClass() {
    }


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Obtain class");
        obtainClassName();


        System.out.println("*************\nObtain Modifiers");
        obtainClassModifiers();

        System.out.println("*************\nObtain Package");
        obtainInfoAboutThePackageFromAClass();

        System.out.println("*************\nObtain SuperClass");
        obtainInfoAboutTheSuperClassFromAClass();

        System.out.println("*************\nObtain Interfaces implemented in the given class");
        obtainInfoAboutTheInterfacesWhichHasImplementedInTheClass();


        System.out.println("*************\nObtain Constructor");
        obtainInfoAboutTheConstructorFromAClass();

        System.out.println("*************\nObtain Methods");
        obtainInfoAboutTheMethodsFromAClass();

        System.out.println("*************\nObtain Fields");
        obtainInfoAboutTheFiledsFromAClass();

        System.out.println("*************\nObtain Annotation");
        obtainInfoAboutTheFiledsFromAClass();
    }

    private static void obtainClassName() throws ClassNotFoundException {
        // Before you can do any inspection on a class you need to obtain its java.lang.Class object
        // if you know the name of the class at compile time

        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        System.out.println(fromClassGetInfoAboutMe);
        // if we don't know the class name at 'Compile Time', but have the class name as a string at runtime, you can do like this:

        // but remember this solution class.forName("fully qualified") it means class name with package name
        Class getFromClassGetInfoAboutMeWithString = Class.forName("se.java.reflection.lablcass.FromClassGetInfoAboutMe");
        System.out.println(getFromClassGetInfoAboutMeWithString);

        System.out.println("Simply name " + fromClassGetInfoAboutMe.getSimpleName());

    }


    private static void obtainClassModifiers() {

        /**
         * You can access the modifiers of a class via the Class object.
         * The class modifiers are the keywords "public", "private", "static" etc.
         * You obtain the class modifiers like this:
         */

        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;
        int modifiers = fromClassGetInfoAboutMe.getModifiers();
        System.out.println(modifiers);

        //  you can get info about the modifiers if it public private etc...
        System.out.println("modifiers info");
        System.out.println(Modifier.isPublic(modifiers));

    }

    private static void obtainInfoAboutThePackageFromAClass() {

        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        Package aPackage = fromClassGetInfoAboutMe.getPackage();

        System.out.println(aPackage);
    }

    private static void obtainInfoAboutTheSuperClassFromAClass() {
        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        System.out.println(fromClassGetInfoAboutMe.getSuperclass());

    }

    private static void obtainInfoAboutTheInterfacesWhichHasImplementedInTheClass() {
        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        // Interfaces are also represented by Class objects in Java Reflection.
        Class[] interfaces = fromClassGetInfoAboutMe.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        /**
         * NOTE: Only the interfaces specifically declared implemented by a given class is returned.
         * If a superclass of the class implements an interface, but the class doesn't specifically
         * state that it also implements that interface, that interface will not be returned in the array.
         * Even if the class in practice implements that interface, because the superclass does.
         */
    }

    private static void obtainInfoAboutTheConstructorFromAClass() {

        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        Constructor[] constructors = fromClassGetInfoAboutMe.getConstructors();

        System.out.println(Arrays.toString(constructors));
    }

    private static void obtainInfoAboutTheMethodsFromAClass() {

        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        Method methods[] = fromClassGetInfoAboutMe.getMethods();

        System.out.println(Arrays.toString(methods));

    }

    private static void obtainInfoAboutTheFiledsFromAClass() {
        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;

        Field []fields = fromClassGetInfoAboutMe.getFields();
        // now you can only get info about the public fields
        // see the class Fields how to get private fields even
        System.out.println(Arrays.toString(fields));
    }

    private static void obtainInfoAboutTheAnnotaionFromAClass() {
        Class fromClassGetInfoAboutMe = FromClassGetInfoAboutMe.class;


        Annotation [] annotations= fromClassGetInfoAboutMe.getAnnotations();

        System.out.println(Arrays.toString(annotations));
    }
}