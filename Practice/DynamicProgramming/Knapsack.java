package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 03-09-2017 at 19:56.
 * HackerRank. DP - Medium. Correct.
 */
public class Knapsack {

    // 2-d Solution.

//    private static int[][] memo;
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int T = s.nextInt();
//        for (int t = 0; t < T; t++) {
//            int n = s.nextInt();
//            int k = s.nextInt();
//            int[] a = new int[n];
//            memo = new int[n][k + 1];
//            for (int i = 0; i < n; i++) a[i] = s.nextInt();
//            System.out.println(dp(a, k, 0));
//        }
//    }
//
//    private static int dp(int[] a, int k, int i) {
//        if (i >= a.length) return 0;
//        if (k <= 0) return 0;
//        if (memo[i][k] != 0) return memo[i][k];
//        int j = 0;
//        int max = 0;
//        while (k - j * a[i] >= 0) {
//            max = Math.max(max, j*a[i] + dp(a, k - j*a[i], i + 1));
//            j++;
//        }
//        return memo[i][k] = max;
//    }

    // 1-d Solution

    private static int[] memo;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] a = new int[n];
            memo = new int[k + 1];
            for (int i = 0; i < n; i++) a[i] = s.nextInt();
            System.out.println(dp(a, k, 0));
        }
    }

    private static int dp(int[] a, int k, int i) {
        if (i >= a.length) return 0;
        if (k <= 0) return 0;
        if (memo[k] != 0) return memo[k];
        int j = 0;
        int max = 0;
        while (k - j * a[i] >= 0) {
            max = Math.max(max, j*a[i] + dp(a, k - j*a[i], i + 1));
            j++;
        }
        return memo[k] = max;
    }

}
