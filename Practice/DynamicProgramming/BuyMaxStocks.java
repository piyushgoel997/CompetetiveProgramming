package DynamicProgramming;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by piyus on 20-08-2017 at 19:56.
 */
public class BuyMaxStocks {
//    static long buyMaximumProducts(int n, long k, int[] a) {
//        //dp = new long[n + 1][n + 1];
//        return solve(k, 0, a);
//    }
//
//    static long[][] dp;
//
//    static long solve(long k, int i, int[]a) {
//        if (dp[i][(int)k] > 0) return dp[i][(int)k];
//        if (k <= 0 || i >= a.length) return 0;
//        long shares = 0;
//        long temp = 0;
//        for (int j = 0; j <= i + 1; j++) {
//            if (k - j*a[i] >= 0)
//                temp = j + solve(k - j*a[i], i + 1, a);
//            if (temp > shares) shares = temp;
//        }
//        dp[i][(int)k] = shares;
//        return shares;
//    }
//
//    static long solve(long k, int i, int[] a) {
//        if (k <= 0 || i >= a.length) return 0;
//        int j = i + 1;
//        while (k - j*a[i] < 0) j--;
//        return Math.max(solve(k, i + 1, a), j + solve(k - j*a[i], i + 1, a));
//    }

    static long buyMaximumProducts(int n, long k, int[] a) {
//        long moneyLeft = k;
//        long shares = 0;
//        for (int i = 0; i < n; i++) {
//            int j = i + 1;
//            while (k - j*a[i] < 0) j--;
//            if (a[i]) {
//                moneyLeft -= j*a[i];
//                shares += j;
//            }
//        }

        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            ht.put(a[i], i);
        }
        Arrays.sort(a);
        long shares = 0;
        long moneyLeft = k;
        for (int i = 0; i < n; i++) {
            if (moneyLeft <= 0) break;
            int j = ht.get(a[i]) + 1;
            while (moneyLeft - j*a[i] < 0) j--;
            moneyLeft -= j*a[i];
            shares = j;
        }
        return shares;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
