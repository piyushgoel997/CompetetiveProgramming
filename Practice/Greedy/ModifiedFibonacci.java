package Greedy;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by piyus on 04-08-2017 at 18:54.
 */
public class ModifiedFibonacci {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        BigInteger t1 = new BigInteger(s.next());
        BigInteger t2 = new BigInteger(s.next());
        int n = s.nextInt();
        System.out.println(fib(t1, t2, n));

    }

    private static BigInteger fib(BigInteger t1, BigInteger t2, int n) {
        BigInteger[] list = new BigInteger[n];
        list[0] = t1;
        list[1] = t2;
        for(int i = 2; i < n; i++) {
            list[i] = new BigInteger(Long.toString(-1));
        }
        return fib(list, n - 1);
    }

    private static BigInteger fib(BigInteger[] list, int i) {
        if(!Objects.equals(list[i], new BigInteger("-1"))) {
            return list[i];
        }
        list[i] = fib(list, i - 2).add(fib(list, i - 1).multiply(fib(list, i - 1)));
        return list[i];
    }
}
