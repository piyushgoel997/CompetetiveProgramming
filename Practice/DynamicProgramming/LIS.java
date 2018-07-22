package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 06-08-2017 at 01:23.
 */
public class LIS {
    // Longest Increasing Sub-sequence.

    /*
    Example -> 8 16 8 1 10 11 4 3 12
    correct output -> 4
     */

    private static int[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(lis(arr, 0));
    }

    private static int lis(int[] arr, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int max = 1;
        for (int j = i + 1; j < arr.length; j++) {
            int l = lis(arr, j);
            if (arr[i] < arr[j]) {
                if (max < l + 1) {
                    max = l + 1;
                }
            } else {
                if (l > max) {
                    max = l;
                }
            }
        }
        dp[i] = max;
        return max;
    }
}
