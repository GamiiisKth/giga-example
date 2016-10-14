package se.java.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ThreadExtendingThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println("Concurrent thread started running..");

    }


    public static void main(String[] args) {


        ThreadExtendingThreadClass extendingThreadClass = new ThreadExtendingThreadClass();

        extendingThreadClass.start();

        //  thread cannot be started twice. If you try to do so, IllegalThreadStateException will be thrown.
        //extendingThreadClass.start();


     //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
