public class FrequentlyUsedFns {
    private static long fastExp(long x, long n, long mod) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans = (ans * x) % mod;
            x = (x * x) % mod;
            n /= 2;
        }
        return ans;
    }

    private static long[] factorialUpto(int x) {
        long[] factorials = new long[x + 1];
        factorials[0] = 1;
        for (int i = 1; i <= x; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }

}
