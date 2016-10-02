package se.java.Enums;

import java.util.Arrays;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         http://www.studytonight.com/java/enumerations.php
 */
public enum Enumerations {
    //enumeration constants these are public, static final by default
    sun, mon, tues, wed, thurs, fri, sat;


    private static class EnumsTest {
        public static void main(String[] args) {
            Enumerations wk;
            wk = Enumerations.sun;
            System.out.println("Today is " + wk);

            try {
                // return the value which match this argument
                System.out.println(Enumerations.valueOf("sun"));
                // return a list of constant which contains in enums
                System.out.println(Arrays.toString(Enumerations.values()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

}
