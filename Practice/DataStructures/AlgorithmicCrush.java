package DataStructures;

import java.util.Scanner;

/**
 * Created by piyus on 13-08-2017 at 21:00.
 * HackerRank. Arrays - Hard. Correct.
 */
public class AlgorithmicCrush {

    /*
Input -
5 3
1 2 100
2 5 100
3 4 100

Output -
200
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        long[] arr = new long[n];

        for (int a0 = 0; a0 < m; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            a--;

            arr[a] += k;
            if (b < n) {
                arr[b] -= k;
            }

        }

        long max = 0;
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += arr[i];
            if (curr > max) {
                max = curr;
            }
        }
        in.close();
        System.out.println(max);
    }
}
