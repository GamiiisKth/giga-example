package se.so4it.learn.java.reflection;

import se.so4it.learn.java.reflection.test.ReflectionTestClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class ReflectionConstructor {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class aClass = null;
        //If you know the precise parameter types of the constructor you want to access, you can do so rather than obtain the array all constructors
        try {
            aClass = Class.forName("se.so4it.learn.java.reflection.test.ReflectionTestClass");
            try {
                Constructor constructor = aClass.getConstructor(new Class[]{String.class});
                System.out.println(constructor);


                System.out.println("\n You can read what parameters a given constructor takes like this:");
                Class[] parameterTypes = constructor.getParameterTypes();
                for (Class parameterType : parameterTypes) {
                    System.out.println(parameterType);
                }


                System.out.println("\nYou can instantiate an object");
                ReflectionTestClass reflectionTestClass = (ReflectionTestClass) constructor.newInstance("ali");
                System.out.println(reflectionTestClass);

                // create a new instance
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
