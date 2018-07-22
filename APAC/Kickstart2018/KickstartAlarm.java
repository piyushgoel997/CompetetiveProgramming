import java.util.Scanner;

public class KickstartAlarm {
    public static void main(String[] args) {
//        System.out.println(bracketTerm(505446,34588));
//        System.out.println(bracketTerm(1, 10));
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int k = s.nextInt();
            long x = s.nextInt();
            long y = s.nextInt();
            long c = s.nextInt();
            long d = s.nextInt();
            long e1 = s.nextInt();
            long e2 = s.nextInt();
            long f = s.nextInt();
            System.out.println("Case #" + (t + 1) + ": " + calculate(n, k, x, y, c, d, e1, e2, f));
        }
    }

    private static long calculate(int n, int k, long x, long y, long c, long d, long e1, long e2, long f) {
        long ans = 0;
        long bracket = 0;
        for (int i = 1; i <= n; i++) {
            long a = (x + y) % f;
            bracket = (bracket + bracketTerm(i, k)) % MOD;
//            System.out.println(a);
//            System.out.println(bracket);
            ans = (ans + (((a * (n - i + 1)) % MOD) * bracket) % MOD) % MOD;
            long xt = ((c * x) % f + (d * y) % f + e1) % f;
            long yt = ((d * x) % f + (c * y) % f + e2) % f;
            x = xt;
            y = yt;
        }
        return ans;
    }

    private static final long MOD = 1000000007;

    private static long bracketTerm(int x, int k) {
//        if (x == 1) return k;
//
//        return (((power(x,k,MOD) - 1L)*x)/(x-1L))%MOD;

        long ans = 0;
        long temp = x;
        for (int j = 1; j <= k; j++) {
            ans = (ans + temp) % MOD;
            temp = (temp * x) % MOD;
        }
//        System.out.println(x);
//        System.out.println(ans);
        return ans;
    }

    private static long power(long x, long y, long p)
    {
        long res = 1;      // Initialize result

        x = x % p;  // Update x if it is more than or
        // equal to p

        while (y > 0)
        {
            // If y is odd, multiply x with result
            if (y % 2 == 1)
                res = (res*x) % p;

            // y must be even now
            y = y/2;
            x = (x*x) % p;
        }
        return res;
    }

}
