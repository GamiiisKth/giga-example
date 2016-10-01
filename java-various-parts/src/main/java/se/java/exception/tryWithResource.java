package se.java.exception;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 * <p>
 * http://www.studytonight.com/java/try-with-resource-statement.php
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This try statement contains a parenthesis in which one or more resources is declare.
 * Any object that implements java.lang.AutoCloseable or java.io.Closeable,
 * can be passed as a parameter to try statement
 * <p>
 * try(resource-specification)
 * {
 * //use the resource
 * }catch()
 * {...}
 */
public class tryWithResource {

    public static void main(String[] args) {
        withoutTry();
        withTry();
    }

    private static void withoutTry() {

        try {
            String str;
//opening file in read mode using BufferedReader stream
            BufferedReader br = new BufferedReader(new FileReader("d:\\myfile.txt"));
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            br.close();    //closing BufferedReader stream
        } catch (IOException ie) {
            System.out.println("withoutTry method -> exception file not found ");
        }

    }

    private static void withTry() {

        try (BufferedReader br = new BufferedReader(new FileReader("d:\\myfile.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ie) {
            System.out.println(" withTry method -> exception file not found ");
        }
    }
}



