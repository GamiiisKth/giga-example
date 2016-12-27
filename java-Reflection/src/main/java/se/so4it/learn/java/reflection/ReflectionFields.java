package se.so4it.learn.java.reflection;

import se.so4it.learn.java.reflection.test.ReflectionTestClass;

import java.lang.reflect.Field;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */

//http://tutorials.jenkov.com/java-reflection/fields.html
public class ReflectionFields {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class aClass = null;

        aClass = ReflectionTestClass.class;

        Field field = aClass.getField("name");

        //Getting and Setting Field Values

        /**
         * The methods Class.getField(String name) and Class.getFields() methods only return *public* fields
         */

        ReflectionTestClass reflectionTestClass = new ReflectionTestClass();

        // getting
        Object o = field.get(reflectionTestClass);
        System.out.println(o);

        // setting
        field.set(reflectionTestClass, "dennis");



    }
}
