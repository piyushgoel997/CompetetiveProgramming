package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 17-08-2017 at 17:17.
 * HackerRank. DP - Medium. Correct.
 */
public class MaximumSubarray {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            boolean allNegative = true;
            int maxValue = Integer.MIN_VALUE;
            int nonContiguousMaxSum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = s.nextInt();
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                }
                if (arr[j] > 0) {
                    nonContiguousMaxSum += arr[j];
                }
                if (arr[j] >= 0) {
                    allNegative = false;
                }
            }
            if (allNegative) {
                System.out.print(maxValue);
                System.out.print(" ");
                System.out.print(maxValue);

            } else {
                System.out.print(maxSumSubarr(arr));
                System.out.print(" ");
                System.out.print(nonContiguousMaxSum);
            }
            System.out.println();
        }
    }

    // Kandane's Algorithm
    private static long maxSumSubarr(int[] arr) {
        long maxSum = 0;
        long maxAtI = 0;
        for (int i : arr) {
            maxAtI += i;
            if (maxAtI < 0) {
                maxAtI = 0;
            }
            if (maxAtI > maxSum) {
                maxSum = maxAtI;
            }
        }
        return maxSum;
    }
}
