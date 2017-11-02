package SeptCkts17;

import java.util.Scanner;

/**
 * Created by piyus on 01-10-2017 at 18:52.
 */
public class NumOfDivisors {
    public static final long MOD = 1000000007;
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long pdt = 1;
        long[] num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = s.nextInt();
            pdt = (pdt * (num[i] + 1)) % MOD;
        }
        long ans = 1;
        for (int i = 0; i < N; i++) {
            long temp = (num[i] * (num[i] + 1))/ 2;
            temp = (temp * (pdt / (num[i] + 1))) % MOD;
            ans = (ans * (temp + 1)) % MOD;
        }
        System.out.println(ans);
    }

    /*long[] inverse(long x, long m) {
        // sx + tm = 1 => return s
        // int q;
        // int r = 1;
        // int s = m % a, t;
        // int a = m, b = m / a;
        // while (r != 1) {
        //     r = b % a;
        //     q = b / a;
        int q, r;
        if (x > m) {
            q = x / m;
            r = x % m;
        } else {  // only this should be used.
            q = m / x;
            r = m % x;
        }
        if (r != 1) {
            long[] st = inverse( x > m ? m : x, r);
            long s = st[0] - st[1] * q;
            long t = st[1];
            return {s, t};
        } else {

        }
    }*/
}
