package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 03-09-2017 at 18:28.
 */
public class BricsGame {

    private static long[][] memo;  // 0 -> myTurn, 1 -> !myTurn  // initialize to -1

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            long[] brick = new long[n];
            for (int j = 0; j < n; j++) brick[j] = s.nextLong();
            memo = new long[n][2];
            for (int j = 0; j < n; j++) {
                memo[j][0] = -1;
                memo[j][1] = -1;
            }
            long[] total = new long[n];
            total[n - 1] = brick[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                total[j] = brick[j] + total[j + 1];
            }
            System.out.println(dp(total, brick, 0, true));
        }
    }

    private static long maxSum(long[] total, long[] brick, int i, boolean myTurn) {
        if (i >= brick.length) return 0;
        if (myTurn && memo[i][0] >= 0) return memo[i][0];
        if (!myTurn && memo[i][1] >= 0) return memo[i][1];
        long one = brick[i] + maxSum(total, brick, i + 1, !myTurn);
        long max = one;
//        long min = IfAtFirst;
        if (i < brick.length - 1) {
            long two = brick[i] + brick[i + 1] + maxSum(total, brick, i + 2, !myTurn);
            max = Math.max(max, two);
//            min = Math.min(min, two);
        }
        if (i < brick.length - 2) {
            long three = brick[i] + brick[i + 1] + brick[i + 2] + maxSum(total, brick, i + 3, !myTurn);
            max = Math.max(max, three);
//            min = Math.min(min, three);
        }
        if (myTurn) return memo[i][0] = max;
        else return memo[i][1] = total[i] - max;
    }


    private static long dp(long[] total, long[] bricks, int i, boolean myTurn) {
        if (i >= bricks.length) return 0;
        if (myTurn && memo[i][0] >= 0) return memo[i][0];
        if (!myTurn && memo[i][1] >= 0) return memo[i][1];

        if (myTurn) {
            long max = bricks[i] + dp(total, bricks, i + 1, !myTurn);
            if (i < bricks.length - 1)
                max = Math.max(max, bricks[i] + bricks[i + 1] + dp(total, bricks, i + 2, !myTurn));
            if (i < bricks.length - 2)
                max = Math.max(max, bricks[i] + bricks[i + 1] + bricks[i + 2] + dp(total, bricks, i + 3, !myTurn));
            return memo[i][0] = max;
        } else {
            long max = bricks[i] + dp(total, bricks, i + 1, myTurn);
            if (i < bricks.length - 1)
                max = Math.max(max, bricks[i] + bricks[i + 1] + dp(total, bricks, i + 2, myTurn));
            if (i < bricks.length - 2)
                max = Math.max(max, bricks[i] + bricks[i + 1] + bricks[i + 2] + dp(total, bricks, i + 3, myTurn));
            return memo[i][1] = total[i] - max;
        }
    }

}
