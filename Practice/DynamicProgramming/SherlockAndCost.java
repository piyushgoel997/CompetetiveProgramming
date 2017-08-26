package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 17-08-2017 at 10:43.
 * HackerRank. DP - Medium. TODO
 */
public class SherlockAndCost {

    private static int[] B;
    private static int n;
    private static long[][] DP;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            n = s.nextInt();
            B = new int[n];
            DP = new long[2][n];
            for (int j = 0; j < n; j++) {
                B[j] = s.nextInt();
            }
            System.out.println(S(0,B[0]));
        }

    }

//    private static long S(int i, int ai) {
//        if (i >= n) {
//            return 0;
//        }
//        if (DP[i] > 0) {
//            return DP[i];
//        }
//        long s = 0;
//        for (int a = 1; a <= B[i]; a++) {  // here a is the a(i+1)
//            long temp = S(i + 1, a) + Math.abs(a - ai);
//            if (temp > s) {
//                s = temp;
//            }
//        }
//        DP[i] = s;
//        return s;
//    }

    private static long S(int i, int ai) {
        if (i >= n - 1) {
            return 0;
        }
//        if (ai == 1) {
//            if (DP[0][i] > 0) {
//                return DP[0][i];
//            }
//        } else {
//            if (DP[1][i] > 0) {
//                return DP[1][i];
//            }
//        }
        long a = S(i + 1, 1) + Math.abs(ai - 1);
        long b = S(i + 1, B[i + 1]) + Math.abs(ai - B[i + 1]);
//        if(ai == 1) DP[0][i] = a;
//        else DP[1][i] = b;
        if (a > b) return a;
        return b;
    }

}
