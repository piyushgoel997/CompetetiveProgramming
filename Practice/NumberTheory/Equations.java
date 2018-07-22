package NumberTheory;

import java.util.Scanner;

/**
 * Created by piyus on 02-09-2017 at 15:02.
 */
public class Equations {

    public static final long MOD = 1000007;

    public static void main(String[] args) {
        System.out.println(factorial(new Scanner(System.in).nextLong()));
    }

    public static long factorial(long n) {
        long fact = 1;
        for (long i = 2; i <= n; i++) System.out.println(i + " " + (fact = (fact * i) % MOD));

        return fact;
    }
    // 34483
}
