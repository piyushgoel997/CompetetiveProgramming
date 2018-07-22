package Jan18;

import java.util.Scanner;

/**
 * Created by piyus on 07-01-2018 at 21:32.
 */
public class StringMerging {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int m = s.nextInt();
            String a = s.next();
            String b = s.next();
            int[][][] dp = new int[n + 1][m + 1][2];
            System.out.println(minFC(a, b, dp, 0, 0, '!'));
        }
    }

    private static int minFC(String a, String b, int[][][] dp, int i, int j, char prev) {
        if (i >= a.length() && j >= b.length()) return 0;
        // dp case
        if (i > 0 && prev == a.charAt(i - 1)) if (dp[i][j][0] > 0) return dp[i][j][0];
        if (j > 0 && prev == a.charAt(j - 1)) if (dp[i][j][1] > 0) return dp[i][j][1];

        // case 1
        int x = 0;
        if (i < a.length()) {
            if (a.charAt(i) != prev) x++;
            x += minFC(a, b, dp, i + 1, j, a.charAt(i));
//            dp[i][j][0] = x;
        } else x = Integer.MAX_VALUE;

        // case 2
        int y = 0;
        if (j < b.length()) {
            if (b.charAt(j) != prev) y++;
            y += minFC(a, b, dp, i, j + 1, b.charAt(j));
//            dp[i][j][1] = y;
        } else y = Integer.MAX_VALUE;
        if (x < y) return dp[i][j][0] = x;
        else return dp[i][j][1] = y;
    }
}
