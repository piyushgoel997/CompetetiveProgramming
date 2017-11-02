package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 03-09-2017 at 20:31.
 * HackerRank. DP - Medium. Correct.
 */
public class RedJohnIsBack {
    private static int[] memo;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            memo = new int[n];
            memo[0] = 1;
            if (memo.length >= 2) memo[1] = 1;
            if (memo.length >= 3) memo[2] = 1;
            if (memo.length >= 4) memo[3] = 2;
            int m = dp(n - 1);
//            System.out.println(m);
            sieveOfErasthones(m);
            int count = 0;
            for (int i = 0; i < primes.length; i++) if (primes[i]) count++;
            System.out.println(count);
        }
    }

    private static int dp(int k) {
        if (memo[k] > 0) return memo[k];
        int x = dp(k - 1);
        if (k >= 4) x += dp(k - 4);
        return memo[k] = x;
    }

    private static boolean[] primes;
    private static void sieveOfErasthones(int n) {
        primes = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) primes[i] = true;
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (primes[i]) for (int j = 2 * i; j < n + 1; j += i) primes[j] = false;
    }
}
