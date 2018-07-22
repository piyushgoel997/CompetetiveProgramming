package Sept17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 05-09-2017 at 19:33.
 */
public class FillMtr {
    static int[][] Q;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int q = s.nextInt();
            Q = new int[q][3];
            table = new HashMap<>();
            for (int i = 0; i < q; i++) {
                Q[i][0] = s.nextInt() - 1;  // i
                Q[i][1] = s.nextInt() - 1;  // j
                Q[i][2] = s.nextInt();  // val
            }
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = -1;
//            System.out.println(dp(0));
        }
    }

    static HashMap<int[], Boolean> table;
    static int[] arr;

//    static boolean dp(int x) {
//        if (x >= Q.length) return true;
//        if (table.containsKey(arr)) return table.get(arr);
//        if (Q[x][2] == 1) {
//            arr[Q[x][0]] = 1;
//            arr[Q[x][0]] = 0;
//            boolean a = dp(arr,)
//        }
//    }

}
