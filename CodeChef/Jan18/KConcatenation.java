package Jan18;

import java.util.Scanner;

/**
 * Created by piyus on 07-01-2018 at 20:22.
 */
public class KConcatenation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
                sum += arr[i];
            }
            long kadane = kadane(arr);
            if (k == 1) {
                System.out.println(kadane);
                continue;
            }
            long max = maxFromBeg(arr) + maxFromEnd(arr);
            if (sum > 0) max += sum * (k - 2);
            System.out.println(Math.max(kadane, max));
        }
    }


    private static long maxFromEnd(int[] arr) {
        long curr = 0;
        long max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            curr += arr[i];
            max = Math.max(max, curr);
        }
        return max;
    }

    private static long maxFromBeg(int[] arr) {
        long curr = 0;
        long max = 0;
        for (int x : arr) {
            curr += x;
            max = Math.max(max, curr);
        }
        return max;
    }

    private static long kadane(int[] arr) {
        long curr = 0;
        long max = Integer.MIN_VALUE;
        for (int x : arr) {
            curr += x;
            max = Math.max(max, curr);
            if (curr < 0) curr = 0;
        }
        return max;
    }

}
