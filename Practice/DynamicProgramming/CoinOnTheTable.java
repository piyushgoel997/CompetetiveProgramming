package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 03-09-2017 at 23:28.
 * HackerRank. DP - Medium. Correct.
 */
public class CoinOnTheTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(), k = s.nextInt();
        char[][] table = new char[n][m];
        for (int i = 0; i < n; i++) table[i] = s.next().toCharArray();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++)
            if (table[i][j] == '*') {
                starN = i;
                starM = j;
            }
        dp = new HashMap[n][m];
        System.out.println(minChanges(table, 0, 0, k));
    }

    private static int starN;
    private static int starM;

    private static HashMap<Integer, Integer>[][] dp;

    private static int minChanges(char[][] table, int posN, int posM, int k) {
        if (Math.abs(posN - starN) + Math.abs(posM - starM) > k) return -1;
        if (dp[posN][posM] != null && dp[posN][posM].containsKey(k)) return dp[posN][posM].get(k);
        if (dp[posN][posM] == null) dp[posN][posM] = new HashMap<>();
//        if (posN < 0 || posN >= table.length || posM < 0 || posM >= table[0].length) return -1;
        if (k <= 0 && table[posN][posM] != '*') return -1;
        if (table[posN][posM] == '*') return 0;
        int min = Integer.MAX_VALUE;
        // U
        if (posN > 0) {
            int x = minChanges(table, posN - 1, posM, k - 1);
            if (x != -1 ) {
                if (table[posN][posM] != 'U') {
                    x++;
                }
                min = Math.min(x, min);
            }
        }
        // L
        if (posM > 0) {
            int x = minChanges(table, posN, posM - 1, k - 1);
            if (x != -1) {
                if (table[posN][posM] != 'L') {
                    x++;
                }
                min = Math.min(x, min);
            }
        }
        // D
        if (posN < table.length - 1) {
            int x = minChanges(table, posN + 1, posM, k - 1);
            if (x != -1) {
                if (table[posN][posM] != 'D') {
                    x++;
                }
                min = Math.min(x, min);
            }
        }
        // R
        if (posM < table[0].length - 1) {
            int x = minChanges(table, posN, posM + 1, k - 1);
            if (x != -1) {
                if (table[posN][posM] != 'R') {
                    x++;
                }
                min = Math.min(x, min);
            }
        }
        dp[posN][posM].put(k, min == Integer.MAX_VALUE ? -1 : min);
        return dp[posN][posM].get(k);
    }

/*
6 8 15
DDDDDDD*
DDDDDDDU
RRDLLLLU
UUUUUUUD
UUDUUUUU
UURRRRRU

ans = 5 not 2, 2 in case of 17 instead of 15
*/

}
