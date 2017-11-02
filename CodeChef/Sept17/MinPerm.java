package Sept17;

import java.util.Scanner;

/**
 * Created by piyus on 04-09-2017 at 18:02.
 */
public class MinPerm {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            boolean odd = false;
            if (n % 2 == 1) {
                odd = true;
                n -= 3;
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) System.out.print((2 * ((i / 2) + 1)) + " ");
                else System.out.print(i + " ");
            }
            if (odd) {
                n += 3;
                System.out.print(n - 1 + " ");
                System.out.print(n + " ");
                System.out.print(n - 2 + " ");
            }
            System.out.println();
        }
    }
}
