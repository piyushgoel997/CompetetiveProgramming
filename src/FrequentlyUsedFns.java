import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FrequentlyUsedFns {

    //TODO from Codechef/CCRT10/IntenseStatistics.java take min, max, sum segment tree.

    public static void main(String[] args) throws IOException {
        // fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // fast output
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        log.write("str\n");

        log.flush();
    }
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

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    // sieve of eratosthenes
    private static boolean[] primeSeive(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) for (int j = 2*i; j <= n; j += i) isPrime[j] = false;
        }
        isPrime[0] = false;
        if (n > 0) isPrime[1] = false;
        return isPrime;
    }

    private static long modInverse(long a, long m) {
        long m0 = m;
        long x = 1;
        long y = 0;

        if (m == 1) return 0;

        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }

        if (x < 0) x += m0;

        return x;
    }

}
