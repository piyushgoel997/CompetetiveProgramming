package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 07-09-2017 at 22:03.
 */
public class SubstringDiff {

    // No DP. Just optimized brute force ~ N^3

//    private static int[][][] dp;
//    private static String p;
//    private static String q;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int S = s.nextInt();
            String p = s.next();
            String q = s.next();
//            dp = new int[p.length()][q.length()][S + 1];
//            maxLenForS(0, 0, S);
            int maxLen = 0;
            for (int i = 0; i < p.length(); i++) {
                for (int j = 0; j < q.length(); j++) {
                    if (p.charAt(i) != q.charAt(j)) continue;
                    int mismatches = 0;
                    int len = 0;
//                    len = Math.max(len, dp[i][j][S]);
                    for (int k = 0; i + k < p.length() && j + k < q.length(); k++) {
                        if (p.charAt(i + k) != q.charAt(j + k)) mismatches++;
                        if (mismatches > S) break;
                        len++;
                    }
                    if (mismatches < S) {
                        for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
                            if (p.charAt(i - k) != q.charAt(j - k)) mismatches++;
                            if (mismatches > S) break;
                            len++;
                        }
                    }
                    maxLen = Math.max(maxLen, len);
                }
            }
            System.out.println(maxLen);
        }
    }

//    private static int fn(int S) {
//        int i = 0;
//        int j = 0;
//        int I = 0;
//        int J = 0;
//        int s = 0;
//        int len = 0;
//        while (I < p.length() && J < q.length()) {
//            if (s < S) {
//                if (p.charAt(I) != q.charAt(J)) s++;
//                I++;
//                J++;
//                len++;
//            } else {
//
//            }
//        }
//    }

//    private static int maxLenForS(int i, int j, int s) {
//        if (i >= p.length() || j >= q.length() || s < 0) return 0;
//        if (dp[i][j][s] > 0) return dp[i][j][s];
//        int len = 0;
//        if (p.charAt(i) == q.charAt(j)) {
//            len = Math.max(len, 1 + maxLenForS(i + 1, j + 1, s));
//            dp[i][j][s] = len;
//        }
//        if (p.charAt(i) != q.charAt(j) && s > 0) {
//            len = Math.max(len, 1 + maxLenForS(i + 1, j + 1, s - 1));
//            dp[i][j][s] = len;
//        }
//        len = Math.max(len, maxLenForS(i, j + 1, s));
//        len = Math.max(len, maxLenForS(i + 1, j, s));
//        return dp[i][j][s];
//    }

}
