package JanCkts18;

import java.util.Scanner;

/**
 * Created by piyus on 21-01-2018 at 13:36.
 */
public class Road {

    private static int[][] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        dp = new int[n + 1][k+1];
        System.out.println(maxPtsPossible(a, 0, k));
    }

    private static int maxPtsPossible(int[] a, int start, int k) {
        if (k < 0) return 0;
        if (start >= a.length) return 0;
        if (dp[start][k] != 0) return dp[start][k];
        int max = 0;
        for (int i = start + 1; i < a.length; i++) {
            max = Math.max(max, maxPtsPossible(a, i, k - Math.abs(a[i] - a[start])));
            if (a[i] == a[start]) break;
        }
        return dp[start][k] = 1 + max;
    }
}
