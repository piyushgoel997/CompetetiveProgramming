package OctCkts17;

import java.util.Scanner;

/**
 * Created by piyus on 26-10-2017 at 00:02.
 * TODO how to optimize for the 3rd query
 */
public class Potential {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] x = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) x[i] = s.nextInt();
        for (int i = 0; i < n; i++) p[i] = s.nextInt();
        for (int i = 0; i < q; i++) {
            switch (s.nextInt()) {
                case 1:
                    x[s.nextInt() - 1] = s.nextInt();
                    break;
                case 2:
                    p[s.nextInt() - 1] = s.nextInt();
                    break;
                case 3:
                    System.out.println(query(x, p, s.nextInt() - 1, s.nextInt() - 1));
            }
        }
    }

    private static int query(int[] x, int[] p, int a, int b) {
        int max = Integer.MIN_VALUE;
        for (int i = a; i <= b; i++) {
            int temp = x[i] + Math.min(p[i], i - a);
            max = Math.max(max, temp);
        }
        return max;
    }
}
