package Sept17;

import java.util.Scanner;

/**
 * Created by piyus on 04-09-2017 at 19:46.
 */
public class SeaCo {
//    private static long[] arr;
//    private static int[][] co;
//    public static final long MOD = 1000000007;
//    public static void main (String[] args) throws java.lang.Exception {
//        Scanner s = new Scanner(System.in);
//        int T = s.nextInt();
//        for (int t = 0; t < T; t++) {
//            int n = s.nextInt();
//            int m = s.nextInt();
//            arr = new long[n];
//            co = new int[m][4];
//            for (int i = 0; i < m; i++) {
//                co[i][0] = s.nextInt();
//                co[i][1] = s.nextInt() - 1;
//                co[i][2] = s.nextInt() - 1;
//                co[i][3] = 1;
//                executeCo(i);
//            }
//            for (int i = 0; i < m; i++) {
//                arr[co[i][1]] = (arr[co[i][1]] + 1) % MOD;
//                if (co[i][2] + 1 < arr.length) arr[co[i][2]] = (arr[co[i][2]] - 1) % MOD;
////                arr[co[i][1]] += co[i][3];
////                if (co[i][2] + 1 < arr.length) arr[co[i][2] + 1] -= co[i][3];
//            }
//            int curr = 0;
//            for (int i = 0; i < n; i++) {
//                curr += arr[i];
//                System.out.print(curr + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static void executeCo(int[][] co, int x) {
//        if (co[x][0] == 1) {
//            arr[co[x][1]] = (arr[co[x][1]] + 1) % MOD;
//            if (co[x][2] + 1 < arr.length) arr[co[x][2] + 1] = (arr[co[x][2] + 1] - 1) % MOD;
//        } else if (co[x][0] == 2) {
//            for (int i = co[x][1]; i <= co[x][2]; i++) {
//                executeCo(co, i);
//            }
//        }
//    }

    private static long[] arr;
    private static final long MOD = 1000000007;
    private static int[][] co;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int m = s.nextInt();
            arr = new long[n];
            co = new int[m][3];
            dp = new long[m][n];
            isDone = new boolean[m];
            for (int i = 0; i < m; i++) {
                isDone[i] = false;
                co[i] = new int[]{s.nextInt(), s.nextInt() - 1, s.nextInt() - 1};
                effectOfCommand(i);
            }
            int curr = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i] = (arr[i] + dp[j][i]) % MOD;
                }
                curr += arr[i];
                System.out.print(curr + " ");
            }
//            int curr = 0;
//            for (int i = 0; i < n; i++) {
//                curr += arr[i];
//                System.out.print(curr + " ");
//            }
            System.out.println();
        }
    }
    private static long[][] dp;
//
//    private static long[] coDP(int x) {
//        if (co[x][0] == 1) {
//            dp[x][0] = 1;
//            dp[x][co[x][1] + 1] += 1;
//            if (co[x][2] + 1 < arr.length) dp[x][co[x][2] + 2] -= 1;
//            return dp[x];
//        } else {
//            for (int i = co[x][1]; i < co[x][2]; i++) {
//                long[] effect = coDP(i);
//                addInDpAt( x, effect);
//            }
//            dp[x][0] = 1;
//            return dp[x];
//        }
//    }
//
//    private static void addInDpAt(int x, long[] effect) {
//        for (int i = 0; i < effect.length; i++) {
//            dp[x][i] += effect[i];
//        }
//    }


    private static boolean[] isDone; // initialize all to false and make the size of dp to 'm'

    private static long[] effectOfCommand(int x) {
        if (isDone[x]) return dp[x];
        if (co[x][0] == 1) {
            isDone[x] = true;
            dp[x][co[x][1]] += 1;
            if (co[x][2] + 1 < dp[x].length) dp[x][co[x][2] + 1] -= 1;
            return dp[x];
        } else {
            long[] temp = new long[arr.length];
            for (int i = co[x][1]; i <= co[x][2]; i++) {
                int j = 0;
                for (long l : effectOfCommand(i)) {
                    temp[j] += l;
                    temp[j] %= MOD;
                    j++;
                }
            }
            isDone[x] = true;
            return dp[x] = temp;
        }
    }

    private static void addInArr(long[] effectOfCommand) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += effectOfCommand[i];
        }
    }


//    private static void executeCo(int[][] co, int x) {
//        if (dp[x][0] != -1) {
//            return dp[x]
//        }
//        if (co[x][0] == 2) ;
//        if (co[x][0] == 1) {
//            arr[co[x][1]] = (arr[co[x][1]] + 1) % MOD;
//            if (co[x][2] + 1 < arr.length) arr[co[x][2]] = (arr[co[x][2]] - 1) % MOD;
//        } else if (co[x][0] == 2) {
//            long[] temp = new ;
//            for (int i = co[x][1]; i <= co[x][2]; i++) {
//                executeCo(co, i);
//            }
//            dp[x][0] = 1;
//            for (int i = 0; i < arr.length; i++) {
//                dp[x][i + 1] = arr[i] - temp[i];
//            }
//        }
//        if (co[x][0] == 2) {
//
//        }
//    }
}
