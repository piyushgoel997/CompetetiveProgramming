package Sept17;

import java.util.Scanner;

/**
 * Created by piyus on 04-09-2017 at 18:01.
 */
public class ChefSum {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < n; i++) {
                int x = s.nextInt();
                if (x < min) {
                    min = x;
                    idx = i;
                }
            }
            System.out.println(idx + 1);
        }
    }
}
