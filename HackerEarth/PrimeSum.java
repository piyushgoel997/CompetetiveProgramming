import java.util.Scanner;

/**
 * Created by piyus on 15-07-2017 at 16:23.
 * HP Think A Thon.
 */
public class PrimeSum {

    static boolean[] isPrime;
    static int MOD = 100001;
    public static void main(String[] args) {
        prime(MOD);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int[] cumSum = new int[n];
        int[] g = new int[n];
        cumSum[0] = a[0] % MOD;
        for (int i = 1; i < n; i++) {
            cumSum[i] = (cumSum[i - 1] + a[i] % MOD) % MOD;
            if (isPrime[cumSum[i]]) {
                g[i] = 1;
            } else {
                g[i] = 0;
            }
        }
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += g[i];
        }
        System.out.println(f);
    }

    public static void prime(int n) {
        isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }
    }
}
