package se.so4it.learn.java.reflection;

import se.so4it.learn.java.reflection.test.ReflectionTestClass;

import java.lang.reflect.Field;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class ReflectionAccessPrivateFields {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class aClass = null;
        aClass = Class.forName("se.so4it.learn.java.reflection.test.ReflectionTestClass");

        /**
         * To access a private field you will need to call the Class.getDeclaredField(String name) or Class.getDeclaredFields() method.
         *
         */


        ReflectionTestClass reflectionTestClass = new ReflectionTestClass(10);

        Field privateField =  ReflectionTestClass.class.getDeclaredField("age");

        privateField.setAccessible(true);

        Integer value=(Integer) privateField.get(reflectionTestClass);

        System.out.println("value: "+value);
    }
}
