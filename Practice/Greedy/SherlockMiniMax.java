package Greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by piyus on 06-09-2017 at 16:21.
 * HackerRank. Greedy - Hard. Correct.
 */
public class SherlockMiniMax {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        int p = s.nextInt(), q = s.nextInt();
        Arrays.sort(a);
        int minDist = 0;
        int m = 0;
        if (p < a[0]) {
            minDist = a[0] - p;
            m = p;
        }
        for (int i = 0; i < n - 1; i++) {
            int mid = (a[i + 1] + a[i]) / 2;
            if (mid < p) if (p < a[i] || p > a[i + 1]) continue;
            else mid = p;
            if (mid > q) if (q < a[i] || q > a[i + 1]) break;
            else mid = q;
            if (mid - a[i] > minDist) {
                m = mid;
                minDist = Math.min(mid - a[i], a[i + 1] - mid);
            }
        }
        if (q > a[n - 1] && q - a[n - 1] > minDist) {
            minDist = q - a[n - 1];
            m = q;
        }
        System.out.println(m);
    }
}
