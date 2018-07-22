import java.util.Scanner;

public class NastyaWardrobe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long mod = 1000000007L;
        long x = s.nextLong();
        long k = s.nextLong();

        if (x == 0) {
            System.out.println(0);
            return;
        }
        x %= mod;
        if (k == 0) {
            System.out.println((2 * x) % mod);
            return;
        }

        long pow = fastExp(2, k, mod);
        long ans = ((2 * pow * x) % mod - pow + 1 + mod) % mod;
        ans = ans % mod;
        System.out.println(ans);
    }

    private static long fastExp(long x, long y, long p) {
        long ans = 1;
        while (y > 0) {
            if (y % 2 == 1) ans = (ans * x) % p;
            x = (x * x) % p;
            y /= 2;
        }
        return ans;
    }

}
