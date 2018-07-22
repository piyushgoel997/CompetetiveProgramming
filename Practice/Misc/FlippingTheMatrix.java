package Misc;

import java.util.Scanner;

/**
 * Created by piyus on 31-08-2017 at 17:08.
 * HackerRank. Constructive Algorithms - Medium. Correct
 */
public class FlippingTheMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        for (int q = 0; q < Q; q++) {
            int n = s.nextInt();
            int[][] matrix = new int[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++) for (int j = 0; j < 2 * n; j++) matrix[i][j] = s.nextInt();
            long sum = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    sum += Math.max(Math.max(matrix[i][j], matrix[i][2 * n - 1 - j]),
                            Math.max(matrix[2 * n - 1 - i][j], matrix[2 * n - 1 - i][2 * n - 1 - j]));
            System.out.println(sum);
        }
    }

}
