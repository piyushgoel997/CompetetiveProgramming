package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 04-09-2017 at 16:25.
 * HackerRank. DP - Medium. Correct.
 */
public class LongestCommomSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        for (int i = 0; i < m; i++) b[i] = s.nextInt();
        System.out.println(lcs(a, b));
    }

//    // for the lendth of the lcs
//    private static String lcs(int[] a, int[] b) {
//        String lcs = "";
//        int n = a.length, m = b.length;
//        int[][] c = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (a[i - 1] != b[j - 1]) c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
//                else {
//                    c[i][j] = c[i - 1][j - 1] + 1;
//                    lcs += a[i - 1] + " ";
//                }
//            }
//        }
//        return lcs;
//    }

    // for the lcs itself
    private static String lcs(int[] a, int[] b) {
        int n = a.length, m = b.length;
        String[][] c = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++) c[i][0] = "";
        for (int i = 0; i <= m; i++) c[0][i] = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                c[i][j] = "";
                if (a[i - 1] != b[j - 1]) {
                    if (c[i - 1][j].length() > c[i][j - 1].length()) c[i][j] = c[i - 1][j];
                    else c[i][j] = c[i][j - 1];
                }
                else {
                    c[i][j] = c[i - 1][j - 1] + a[i - 1] + " ";
                }
            }
        }
        return c[n][m];
    }
}
