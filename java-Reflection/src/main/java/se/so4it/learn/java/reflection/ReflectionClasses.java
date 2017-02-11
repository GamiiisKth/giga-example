package se.so4it.learn.java.reflection;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class ReflectionClasses {


    public static void main(String[] args) {
        try {
            //  The fully qualified class name (including package name)
            Class aClass = Class.forName("se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClientImpl");

            System.out.println(aClass.getSimpleName());

            System.out.println("access the modifiers of a class via the Class object. The class modifiers are the keywords 'public', private, static, 'etc' ");
            System.out.println(aClass.getModifiers());

            System.out.println("You can obtain information about the package from a Class object like this: ");
            System.out.println(aClass.getPackage());

            System.out.println("\nFrom the Class object you can access the superclass of the class");
            System.out.println(aClass.getSuperclass());

            System.out.println("\nIt is possible to get a list of the interfaces implemented by a given class");
            Class[] interfaces = aClass.getInterfaces();
            for (Class face : interfaces) {
                System.out.println(face);
            }

            System.out.println("\nYou can access the constructors of a class like this: ");
            Constructor[] constructors = aClass.getConstructors();

            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("\nYou can access the fields (member variables) of a class like this: ");
            Field[] fields = aClass.getFields();

            for (Field field1:fields){
               // System.out.println(field1);
            }

            System.out.println("\nYou can access the class annotations of a class like this: ");
            Annotation[] annotations = aClass.getAnnotations();
            for (Annotation annotation:annotations){
                System.out.println(annotation);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
