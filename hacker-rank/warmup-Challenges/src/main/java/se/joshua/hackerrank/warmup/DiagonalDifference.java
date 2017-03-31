package se.joshua.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         https://www.hackerrank.com/challenges/diagonal-difference
 */
public class DiagonalDifference {


    public static void main(String[] args) {

        System.out.println("enter number of lines");

        Scanner scanner = new Scanner(System.in);

        int nrOfLines = scanner.nextInt();

        int[][] matrix = new int[nrOfLines][nrOfLines];

        System.out.println("enter first line");

        int j = nrOfLines;

        for (int i = 0; i < nrOfLines; i++ ) {
            if ( j <0){
                break;
            }

            System.out.println("enter: " + i);
            int nr = scanner.nextInt();

            matrix[j][i] = nr;
            j--;
        }

        j = nrOfLines;


    }


}
