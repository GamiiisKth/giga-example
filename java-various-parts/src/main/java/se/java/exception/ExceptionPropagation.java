package se.java.exception;

import java.io.IOException;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 * http://www.dreamincode.net/forums/topic/22663-exceptions-advanced-customizing/
 *
 */
public class ExceptionPropagation {


    static class Testthrows1 {
        void m() throws IOException {
            throw new IOException("device error");//checked exception
        }

        void n() throws IOException {
            m();
        }

        void p() {
            try {
                n();
            } catch (Exception e) {
                System.out.println(e.getStackTrace()[0]);
                System.out.println(e.getMessage());
            }
        }

        public static void main(String args[]) {
            Testthrows1 obj = new Testthrows1();
            obj.p();
            System.out.println("normal flow...");
        }
    }
}
