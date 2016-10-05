package se.java.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         read readme.txt file
 *
 *         http://www.studytonight.com/java/java-io-stream
 */
public class Streams {



    public static void main(String[] args) throws IOException {
        //Reading Console Input

        //Reader: Abstract class that define character stream input
                                // BufferedReader constructor takes a reader concrete class

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char c = (char) bufferedReader.read();


    }


}

