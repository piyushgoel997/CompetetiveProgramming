package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 18-08-2017 at 15:43.
 * HackerRank. DP - Hard. Correct.
 */
public class CoinChangeProblem {

    private static int[] coins;
    private static long[][] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        if (m <= 0) {
            System.out.println(0);
            return;
        }
        if (n <= 0) {
            System.out.println(1);
            return;
        }
        coins = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = s.nextInt();
        }
        Arrays.sort(coins);
        dp = new long[m + 1][n + 1];
        System.out.println(waysOfChange(n, 0));
    }

    private static long waysOfChange(int value, int coinPos) {
        if (value == 0 && coinPos <= coins.length) {
            return 1;
        }
        if (value <= 0 || coinPos >= coins.length) {
            return 0;
        }
        if (dp[coinPos][value] > 0) {
            return dp[coinPos][value];
        }

        long count = 0;
        for (int i = 0; i <= value; i++) {
            count += waysOfChange(value - i * coins[coinPos], coinPos + 1);
        }
        dp[coinPos][value] = count;
        return count;
    }

//    private static long waysOfChange(int value, int numOfCoins, int coinPos) {
//        if (value == 0 && numOfCoins == 0) {
//            return 1;
//        }
//        if (value <= 0 || numOfCoins <= 0) {
//            return 0;
//        }
//        if (!(coinPos<coins.length)) {
//            return 0;
//        }
//
//        long count = 0;
//        for (int i = 0; i <= numOfCoins; i++) {
//            count += waysOfChange(value - i * coins[coinPos], numOfCoins - i, coinPos + 1);
//        }
//        return count;
//    }

//    private static long waysOfChange(int n, int numOfCoins) {
//        if (n == 0 && numOfCoins == 0) {
//            return 1;
//        }
//        if (n <= 0 || numOfCoins <= 0) {
//            return 0;
//        }
//        if (dp[n][numOfCoins] > 0) {
//            return dp[n][numOfCoins];
//        }
//
//        long ways = 0;
//        for (int i = 0; i < coins.length; i++) {
////            if (n - coins[i] > (numOfCoins - 1) * coins[0]) {
//            ways += waysOfChange(n - coins[i], numOfCoins - 1);
////            }
//        }
//        dp[n][numOfCoins] = ways;
//        return ways;
//    }

    // Wrong method repeats subcases.
//    private static long waysOfChange(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n < 0) {
//            return 0;
//        }
//        if (dp[n] > 0) {
//            return dp[n];
//        }
//        long ways = 0;
//        for (int coin : coins) {
//            ways += waysOfChange(n - coin);
//        }
//        dp[n] = ways;
//        return ways;
//    }

}
