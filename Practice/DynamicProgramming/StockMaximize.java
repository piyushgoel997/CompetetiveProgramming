package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 03-09-2017 at 17:24.
 * HackerRank. DP - Medium. Correct.
 */
public class StockMaximize {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            long[] sharePrice = new long[n];
            for (int i = 0; i < n; i++) sharePrice[i] = s.nextLong();
            // dp
            long[][] profit = new long[n][2];
            profit[n - 1][1] = sharePrice[n - 1];
            dp(sharePrice, profit, 0);
            System.out.println(profit[0][0]);

        }
    }

    private static long dp(long[] sharePrice, long[][] profit, int i) {
        if (i >= sharePrice.length - 1) return sharePrice[sharePrice.length - 1];
        profit[i][1] = Math.max(sharePrice[i], dp(sharePrice, profit, i + 1));
        profit[i][0] = profit[i + 1][0];
        if (profit[i + 1][1] - sharePrice[i] > 0) profit[i][0] += profit[i + 1][1] - sharePrice[i];
        return profit[i][1];
    }
}
