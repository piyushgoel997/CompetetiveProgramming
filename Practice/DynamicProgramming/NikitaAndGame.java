package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 07-09-2017 at 02:36.
 * HackerRank. DP - Medium. Correct.
 */
public class NikitaAndGame {

    // DP need not be used since no repeating subproblems.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = s.nextInt() + a[i - 1];
            System.out.println(maxScore(1, n));
        }
    }

    private static int[] a;

    private static int maxScore(int start, int end) {
        int maxScore = 0;
        for (int j = start; j < end; j++) {
            if (a[j] - a[start - 1] == a[end] - a[j]) {
                maxScore = Math.max(Math.max(maxScore(j + 1, end), maxScore(start, j)) + 1, maxScore);
                break;
            }
        }
        return maxScore;
    }

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int T = s.nextInt();
//        for (int t = 0; t < T; t++) {
//            int n = s.nextInt();
//            a = new int[n];
//            a[0] = s.nextInt();
//            for (int i = 1; i < n; i++) a[i] = s.nextInt() + a[i - 1];
//            dp = new int[n + 1][n + 1];
//            for (int i = 0; i <= n; i++) for (int j = 0; j <= n; j++) dp[i][j] = -1;
//            System.out.println(maxScore(0, n));
//        }
//    }
//
//    private static int[][] dp;
//    private static int[] a;
//
//    private static int maxScore(int start, int end) {
//        if (end - start <= 1) return 0;
//        if (dp[start][end] != -1) return dp[start][end];
//        int ls = 0;
//        if (start > 0) {
//            ls = a[start - 1];
//        }
//        int maxScore = 0;
//        for (int j = start; j < end; j++) {
//            if (a[j] - ls == a[end - 1] - a[j]) {
//                maxScore = Math.max(Math.max(maxScore(j + 1, end), maxScore(start, j + 1)) + 1, maxScore);
////                break;
//            }
//        }
//        return dp[start][end] = maxScore;
//    }

}
