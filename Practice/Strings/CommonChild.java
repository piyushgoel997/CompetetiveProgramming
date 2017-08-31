package Strings;

import java.util.Scanner;

/**
 * Created by piyus on 28-08-2017 at 16:55.
 * HackerRank. Strings - Medium. Correct.
 */
public class CommonChild {

    // All the solutions are O(n^2) but strangely the memoization solution fail in some test cases but to timeout.

    // Solution using memoization.

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String a = s.next();
//        String b = s.next();
//        dp = new int[a.length() + 1][b.length() + 1];
//        for (int i = 1; i <= a.length(); i++)
//            for (int j = 1; j <= b.length(); j++) dp[i][j] = -1;
//        System.out.println(longestCommonChild(a, b));
//    }

//    private static int[][] dp;

//    private static int longestCommonChild(String a, String b) {
//        if (a.length() <= 0 || b.length() <= 0) return 0;
//        if (dp[a.length()][b.length()] >= 0) return dp[a.length()][b.length()];
//        int ixa = b.indexOf(a.charAt(0));
//        int includeA = ixa == -1 ? 0 : longestCommonChild(a.substring(1), b.substring(ixa + 1)) + 1;
//        int ixb = a.indexOf(b.charAt(0));
//        int includeB = ixb == -1 ? 0 : longestCommonChild(a.substring(ixb + 1), b.substring(1)) + 1;
//        int includeNone = longestCommonChild(a.substring(1), b.substring(1));
//        if (includeNone > includeA && includeNone > includeB) return dp[a.length()][b.length()] = includeNone;
//        if (includeA > includeB) return dp[a.length()][b.length()] = includeA;
//        return dp[a.length()][b.length()] = includeB;
//    }

//    private static int longestCommonChild(String a, String b) {
//        if (a.length() <= 0 || b.length() <= 0) return 0;
//        if (dp[a.length()][b.length()] >= 0) return dp[a.length()][b.length()];
//        if (a.charAt(0) == b.charAt(0)) return dp[a.length()][b.length()] = longestCommonChild(a.substring(1), b.substring(1)) + 1;
//        return dp[a.length()][b.length()] = Math.max(longestCommonChild(a.substring(1), b), longestCommonChild(a, b.substring(1)));
//    }

    // solution using bottom up

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(longestCommonChild(s.next(), s.next()));
    }

    private static int longestCommonChild(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int p = 1; p <= a.length(); p++)
            for (int q = 1; q <= b.length(); q++) {
                if (a.charAt(p - 1) == b.charAt(q - 1)) dp[p][q] = dp[p - 1][q - 1] + 1;
                else dp[p][q] = Math.max(dp[p - 1][q], dp[p][q - 1]);
            }
        return dp[a.length()][b.length()];
    }

}
