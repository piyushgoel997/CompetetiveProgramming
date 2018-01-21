package Jan18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 07-01-2018 at 20:05.
 */
public class MaximumScore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            long[][] arr = new long[n][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) arr[i][j] = s.nextLong();
            long prev = Integer.MAX_VALUE;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                long max = find(arr[i], prev);
                if (max < 0) {
                    sum = -1;
                    break;
                }
                sum += max;
                prev = max;
            }
            System.out.println(sum);
        }
    }

    private static long find(long[] a, long prev) {
        long max = -1;
        for (long x : a) {
            if (x < prev) if (x > max) max = x;
        }
        return max;
    }
}
