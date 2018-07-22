import java.util.Scanner;

/**
 * Created by piyus on 6/8/2017.
 * Code Jam Round 1A 2017 B.
 */
public class AlphabetCake {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            char[][] cake = new char[r][c];
            for (int j = 0; j < r; j++) {
                String str = in.next();
                for (int k = 0; k < c; k++) {
                    cake[j][k] = str.charAt(k);
                }
            }
            divideCake(cake);
            System.out.println("Case #" + (i + 1) + ": "); //TODO
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    System.out.print(cake[j][k]);
                }
                System.out.println();
            }
        }

    }

    private static void divideCake(char[][] cake) {
        for (int i = 0; i < cake.length; i++) {
            char c = '?';
            for (int j = 0; j < cake[i].length; j++) {
                if (cake[i][j] != '?') {
                    c = cake[i][j];
                }
                cake[i][j] = c;
            }
            c = '?';
            for (int j = cake[i].length - 1; j >= 0; j--) {
                if (cake[i][j] != '?') {
                    c = cake[i][j];
                } else {
                    cake[i][j] = c;
                }
            }
        }

        char[] c = cake[0];
        for (int i = 0; i < cake.length; i++) {
            if (cake[i][0] != '?') {
                c = cake[i];
            } else {
                cake[i] = c;
            }
        }
        c = cake[cake.length - 1];
        for (int i = cake.length - 1; i >= 0; i--) {
            if (cake[i][0] != '?') {
                c = cake[i];
            } else {
                cake[i] = c;
            }
        }
    }
}