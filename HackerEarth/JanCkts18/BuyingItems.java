package JanCkts18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by piyus on 26-01-2018 at 14:13.
 */
public class BuyingItems {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Set[] objs = new Set[m];
        int[] cost = new int[m];

        for (int i = 0; i < m; i++) {
            objs[i] = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                int b = s.nextInt();
                if (b > 0) objs[i].add(j);
            }
            cost[i] = s.nextInt();
        }
    }
}
