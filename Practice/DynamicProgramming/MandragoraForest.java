package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 04-09-2017 at 16:35.
 * HackerRank. DP - Medium. Correct.
 */
public class MandragoraForest {

    // Solutions if the can be defeated in any order
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            long[] h = new long[n];
            for (int i = 0; i < n; i++) h[i] = s.nextLong();
            Arrays.sort(h);
            for (int i = n - 2; i >= 0; i--) h[i] += h[i + 1];
            long max = 0;
            for (int i = 0; i < n; i++)
                if ((i + 1) * h[i] > max) max = (i + 1) * h[i];
            System.out.println(max);
        }
    }

//    // Solutions if the can be defeated in a fixed order
//    private static long[][] P;
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int T = s.nextInt();
//        for (int t = 0; t < T; t++) {
//            int n = s.nextInt();
//            int[] h = new int[n];
//            for (int i = 0; i < n; i++) h[i] = s.nextInt();
//            P = new long[n][n + 1];
//            System.out.println(dp(h, 0, 1));
//            System.out.println();
//        }
//    }
//
//    private static long dp(int[] h, int pos, int strength) {
//        if (pos >= h.length) return 0;
//        if (P[pos][strength] > 0) return P[pos][strength];
//        long eat = dp(h, pos + 1, strength + 1);
//        long battle = strength * h[pos] + dp(h, pos + 1, strength);
//        return P[pos][strength] = Math.max(eat, battle);
//    }
}
