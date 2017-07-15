import java.util.Scanner;

/**
 * Created by piyus on 15-07-2017 at 18:47.
 * HP Think A Thon.
 */
public class FootballTournament {
    static long n;
    static long k;
    static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            n = s.nextLong();
            k = s.nextLong();
            long sum = 0;
            for (int j = 0; j <= n; j++) {
                sum = (sum + F(j)) % MOD;
            }
            System.out.println(sum);
        }

    }

    static long F(int i) {
//        long n1 = fact(k + i - 1);
//        long n2 = fact(k + n - i - 1);
//        long d1 = (fact(i) * fact(k - 1));
//        long d2 = (fact(k - 1) * fact(n - i));
//        long a = n1 / d1;
//        long b = n2 / d2;
//        return (a * b) % MOD;
        long a = nCr(k + i - 1, k - 1);
        long b = nCr(k + n - i - 1, k - 1);
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    static long fact(long k) {
        long ans = 1;
        for (long i = 2; i <= k; i++) {
//            ans = ((ans % MOD) * (i % MOD)) % MOD;
            ans = ans * i;
        }
        return ans;
    }

    static long nCr(long n, long r) {
        long limit = r > (n - r) ? r : (n - r);
        long sec = limit == r ? (n - r) : r;
        long num = 1;
        for (long i = limit+1; i <= n; i++) {
//            num = ((num % MOD) * (i % MOD)) % MOD;
            num = num * i;
        }
        sec = fact(sec);
        return num / sec;
    }
}
