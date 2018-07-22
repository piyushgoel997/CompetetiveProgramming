package JanCkts18;

import java.util.Scanner;

/**
 * Created by piyus on 21-01-2018 at 13:09.
 */
public class MikeAndCongruenceRelation {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long k = s.nextLong();
        long x = n / k;
        long ans = (n % k) * sumUpto(x) + (k - (n % k)) * sumUpto(x - 1);
        System.out.println(ans);
    }

    private static long sumUpto(long x) {
        return (x * (x + 1)) / 2;
    }
}
