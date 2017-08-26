package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 17-08-2017 at 13:37.
 * HackerRank. DP - Medium. Correct.
 */
public class SamAndSubStrings {

    private static final int MOD = 1000000007;
    private static long total;

    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        total = str.charAt(0) - '0';
        dp(str, str.length() - 1);
        System.out.println(total);
    }

    private static long dp(String str, int i) {
        if (i == 0) {
            return str.charAt(0) - '0';
        }
        long dp = (10 * dp(str, i - 1) + (i + 1) * (str.charAt(i) - '0')) % MOD;
        total = (total + dp) % MOD;
        return dp;
    }

//    private static long fn(String str) {
//        if (str.length() == 0) {
//            return 0;
//        }
//        long ans = 0;
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i + 1; j <= str.length(); j++) {
//                ans += toNum(str.substring(i, j)) % MOD;
//                ans = ans % MOD;
//            }
//        }
//        return ans;
//    }
//
//    private static long toNum(String str) {
//        long num = 0;
//        for (int i = 0; i < str.length(); i++) {
//            num += (str.charAt(i) - 48) * Math.pow(10, str.length() - i - 1);
//        }
//        return num;
//    }
//
//    private static int[][] DP;
//
//    private static void dp(String str, int start, int end) {
//        if (DP[start][end] > 0) {
//            return;
//        }
//        total += toNum(str);
//        DP[start][end] = 1;
//        for (int i = 0; i < str.length(); i++) {
//            dp(str.substring(0, i), start, start + i);
//            dp(str.substring(i), start + i, end);
//        }
//
//    }
}
