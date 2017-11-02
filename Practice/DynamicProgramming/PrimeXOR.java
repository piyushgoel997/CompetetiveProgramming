package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 03-09-2017 at 14:14.
 * TODO
 */
public class PrimeXOR {

    private static boolean[] primes;
    public static final long MOD = 1000000007;
    private static int[][] dp;

    public static void main(String[] args) {
        /*
        Test case 3
1
4
3509 3512 3512 3511

ans  5
         */
        System.out.println(13 ^ 2 ^ 3509);
        System.out.println(3511 ^ 3509);
        System.out.println(3512 ^ 3509);

        sieveOfErasthones(8191);
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        for (int q = 0; q < Q; q++) {
            int n = s.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int c = s.nextInt();
                if (hm.containsKey(c)){ hm.put(c, hm.get(c) + 1);} else hm.put(c, 1);
            }
            // making the dp table
            dp = new int[hm.size()][hm.size()];
            Integer[] list = hm.keySet().toArray(new Integer[hm.size()]);
            for (int i = 0; i < dp.length; i++) dp[i][0] = list[i];
            for (int i = 1; i < list.length; i++) dp(list, 0, list.length - i);
            // dp table made

            int[] counts = new int[list.length];
            for (int i = 0; i < counts.length; i++) {
                counts[i] = (hm.get(list[i]) + 1) / 2;
            }
            System.out.println(dp(list, counts, 0, 0, 0));
//            long ans = 0;
//            for (int i = 0; i < dp.length; i++) for (int j = 0; j < dp[0].length - i; j++)
//                    if (primes[dp[i][j]]) {
//                        long a = 1;
//                        for (int k = i; k <= i + j; k++) a = (a * counts[k]) % MOD;
//                        ans = (ans + a) % MOD;
//                    }
//            System.out.println(ans);
        }
    }

    private static long dp(Integer[] list, int[] count, int i, int xor, long ct) {
        if (i >= list.length) return 0;
        long ans = 0;
        if (primes[xor ^ list[i]]) ans += (ct * count[i]) % MOD;
        long temp = 0;
        for (int j = i; j < list.length; j++) {
            temp += dp(list, count, j + 1, xor ^ list[i], (ct * count[i]) % MOD) % MOD;
        }
        return ct * count[i] * temp + ans;
    }

    private static int dp(Integer[] list, int x, int n) {
        if (dp[x][n] != 0) return dp[x][n];
        return dp[x][n] = list[x] ^ dp(list, x + 1, n - 1);
    }

    private static void sieveOfErasthones(int n) {
        primes = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) primes[i] = true;
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (primes[i]) for (int j = i; j < n + 1; j += i) primes[j] = false;
    }
}
