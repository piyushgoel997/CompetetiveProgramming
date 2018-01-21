import java.util.Scanner;

/**
 * Created by piyus on 03-12-2017 at 20:39.
 */
public class ConstructTheArray {

    public static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }

    private static long countArray(int n, int k, int x) {
//        long ans = 0;
//        long pow = 1;
//        int neg = 1;
//        for (int i = 0; i <= n - 2; i++) {
//            ans = (ans + (pow * neg) + MOD) % MOD;
//            pow = (pow * (k - 1) + MOD) % MOD;
//            neg *= -1;
//        }
//        if (ans < 0) ans = (-1 * ans + MOD) % MOD;

        long[] pows = new long[n];
        pows[0] = 1;
        for (int i = 1; i <= n - 2; i++) {
            pows[i] = (MOD + pows[i - 1] * ((k - 1)% MOD))%MOD;
        }

        long ans = 0;
        int neg = 1;
        for (int i = n - 2; i >= 0; i--) {
            ans = (MOD + ans + (neg * (pows[i] % MOD) + MOD) % MOD) % MOD;
            neg = -1 * neg;
        }
        if (x == 1) {
            if (n % 2 == 0) {
                ans = (ans - 1) % MOD;
            } else {
                ans = (ans + 1) % MOD;
            }
        }
        return ans % MOD;


//        long a = 1;
//        long b = 1;
//        for (int i = 0; i < n - 3; i++) {
//            a = (a * (k - 1)) % MOD;
//            b = (b * (k - 2)) % MOD;
//        }
//        if (x == 1) {
//            return ((a * (k - 2)) % MOD - (((b * (k - 1)) % MOD) * (k - 3)) % MOD) % MOD;
//        }
//        return (k - 2) * (a - (b * (k - 3) % MOD) % MOD);

//        long ans = (k - 2) % MOD;
//        for (int i = 0; i < n - 3; i++) {
//            ans = (ans * ((k - 1) % MOD)) % MOD;
//        }
//        return ans;
    }
}
