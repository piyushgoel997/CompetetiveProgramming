package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 15-10-2017 at 15:07.
 * http://www.geeksforgeeks.org/knapsack-problem/
 */
public class Knapsack01 {

/*
1
58
41
57 95 13 29 1 99 34 77 61 23 24 70 73 88 33 61 43 5 41 63 8 67 20 72 98 59 46 58 64 94 97 70 46 81 42 7 1 52 20 54 81 3 73 78 81 11 41 45 18 94 24 82 9 19 59 48 2 72
83 84 85 76 13 87 2 23 33 82 79 100 88 85 91 78 83 44 4 50 11 68 90 88 73 83 46 16 7 35 76 31 40 49 65 2 18 47 55 38 75 58 86 77 96 94 82 92 10 86 54 49 65 44 77 22 81 52

ans = 223
*/

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int w = s.nextInt();
            int[] wt = new int[n];
            int[] value = new int[n];
            for (int i = 0; i < n; i++) value[i] = s.nextInt();
            for (int i = 0; i < n; i++) wt[i] = s.nextInt();
            System.out.println(maxPossibleValue(0, w, n, wt, value));
        }
    }

    private static int maxPossibleValue(int i, int w, int n, int[] wt, int[] value) {
        if (i >= n) return 0;
        if (w <= 0) return 0;
        int including = 0;
        if (w >= wt[i]) including = value[i] + maxPossibleValue(i + 1, w - wt[i], n, wt, value);
        return Math.max(maxPossibleValue(i + 1, w, n, wt, value), including);
    }
}
