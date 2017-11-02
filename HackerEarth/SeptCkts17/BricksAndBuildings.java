package SeptCkts17;

import java.util.Scanner;

/**
 * Created by piyus on 30-09-2017 at 18:06.
 */
public class BricksAndBuildings {

    // Highly optimized
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] ht = new int[100001];
        for (int i = 0; i < N; i++) ht[s.nextInt()]++;
        int[] table = new int[100001];
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int k = s.nextInt();
            if (table[k] == 0) {
                int ct = 0;
                for (int j = k; j < 100001; j += k) ct += ht[j];
                table[k] = ct;
            }
            System.out.println(table[k]);
        }
    }

    /*private static int[] table = new int[100001];
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] ht = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            ht[i] = s.nextInt();
            if (ht[i] > max) max = ht[i];
        }
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int k = s.nextInt();
            if (k > max) System.out.println(0);
            else System.out.println(query(ht, k));
        }
    }

    private static int query(int[] ht, int k) {
        if (table[k] > 0) return table[k];
        int ct = 0;
        for (int aHt : ht) if (aHt >= k && aHt % k == 0) ct++;
        return table[k] = ct;
    }*/

}
