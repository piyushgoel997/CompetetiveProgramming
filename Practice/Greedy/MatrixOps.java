package Greedy;

import java.util.Scanner;

/**
 * Created by piyus on 25-07-2017 at 23:56.
 * Hacker Earth
 */
public class MatrixOps {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long m = s.nextLong();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += s.nextLong();
            }
        }

    }
}
