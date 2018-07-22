package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by piyus on 06-09-2017 at 00:34.
 * HackerRank. Greedy - Hard. Correct.
 */
public class CuttingBoards {
    public static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        for (int q = 0; q < Q; q++) {
            int m = s.nextInt(), n = s.nextInt();
            Long[] cy = new Long[m - 1];
            Long[] cx = new Long[n - 1];
            for (int i = 0; i < m - 1; i++) cy[i] = s.nextLong();
            for (int i = 0; i < n - 1; i++) cx[i] = s.nextLong();
            Arrays.sort(cy, Collections.reverseOrder());
            Arrays.sort(cx, Collections.reverseOrder());
            int i = 0;
            int j = 0;
            long horSegs = 1;
            long vertSegs = 1;
            long cost = 0;
            while (i < m - 1 && j < n - 1) {
                if (cy[i] > cx[j]) {
                    cost = (cost + horSegs * cy[i] % MOD) % MOD;
                    vertSegs++;
                    i++;
                } else {
                    cost = (cost + vertSegs * cx[j] % MOD) % MOD;
                    horSegs++;
                    j++;
                }
            }
            while (i < m - 1) {
                cost = (cost + (horSegs * cy[i]) % MOD) % MOD;
                vertSegs++;
                i++;
            }
            while (j < n - 1) {
                cost = (cost + vertSegs * cx[j] % MOD) % MOD;
                horSegs++;
                j++;
            }
            System.out.println(cost);
        }
    }
}
