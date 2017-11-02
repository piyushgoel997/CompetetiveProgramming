package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 11-09-2017 at 19:47.
 * HackerRank. DP - Medium. Combinatorics.
 * https://www.hackerrank.com/challenges/lego-blocks/editorial
 */
public class LegoBlocks {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt(); // height
            int m = s.nextInt(); // width
            if (n == 1) {
                if (m > 4) System.out.println(0);
                else System.out.println(1);
                continue;
            }
            ways = new long[m + 1];
            waysOfOneRow(m);
            for (int i = 1; i <= m; i++) ways[i] = pow(ways[i], n);
            solid = new long[m + 1];
            System.out.println(findSolid(m));
        }
    }

    private static long findSolid(int m) {
        if (m <= 0) return 0;
        if (m == 1) return 1;
        if (solid[m] > 0) return solid[m];
        long temp = 0;
        for (int i = 1; i < m; i++) {
            temp = (temp + (findSolid(i) * ways[m - i])) % MOD;
        }
        return solid[m] = (ways[m] - temp + MOD) % MOD;
    }

    private static long[] solid;
    private static long[] ways;
    private static long waysOfOneRow(int m) {
        if (m == 0) return 1;
        if (m < 0) return 0;
        if (ways[m] > 0) return ways[m];
        return ways[m] = (waysOfOneRow(m - 1) + waysOfOneRow(m - 2) + waysOfOneRow(m - 3) + waysOfOneRow(m - 4)) % MOD;
    }

    private static long pow(long x, long n) {
        long ans = 1;
        for (int i = 0; i < n; i++) ans = (ans * x) % MOD;
        return ans;
    }
}
