package DynamicProgramming;

/**
 * Created by piyus on 13-09-2017 at 01:56.
 * DP. Minimize the number of operations required while multiplying matrices, by choosing the order of operation.
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {10, 20, 30};
        System.out.println(minOps(p));
    }

    private static int[][] dp;
    private static int minOps(int[] a) {
        dp = new int[a.length][a.length];
        return minOps(dp, a, 0, a.length - 2);
    }

    private static int minOps(int[][] dp, int[] a, int start, int end) {
        if (end - start == 1) return dp[start][end] = a[start] * a[end] * a[end + 1];
        if (end - start < 1) return 0;
        if (dp[start][end] > 0) return dp[start][end];
        int minOps = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) { // insert bracket after i
            int ops = a[start] * a[i + 1] * a[end + 1];
            ops += minOps(dp, a, start, i) + minOps(dp, a, i + 1, end);
            minOps = Math.min(minOps, ops);
        }
        return dp[start][end] = minOps;
    }

}
