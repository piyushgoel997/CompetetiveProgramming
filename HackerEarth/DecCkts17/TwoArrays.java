package DecCkts17;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 15-12-2017 at 21:22.
 */
public class TwoArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = s.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 0;
        for (int size = (int) Math.sqrt(k); size < Math.min(n, m); size++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                if (!map.containsKey(a[i])) map.put(a[i], 1);
                else map.put(a[i], map.get(a[i]) + 1);
            }
            for (int j = 0; j < a.length - size; j++) {
                if (j > 0) {
//                    map
                }
            }
        }
    }

}
