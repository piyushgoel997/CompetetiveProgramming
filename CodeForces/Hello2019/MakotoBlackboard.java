import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MakotoBlackboard {
    public static final long MOD = 1000_000_007;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long k = s.nextLong();
//        HashMap<Long, Long> num = new HashMap<>();
//        HashMap<Long, Long> den = new HashMap<>();
        HashMap<Long, Long> fact = new HashMap<>();

        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                fact.put(i, 1L);
                fact.put(n / i, 1L);
            }
        }
        HashMap<Long, HashSet<Long>> isFact = new HashMap<>();
        HashMap<Long, Long> numFacts = new HashMap<>();
        for (long l : fact.keySet()) {
//            den.put(l, (long) num.size());
            isFact.put(l, new HashSet<>());
            for (long x : fact.keySet()) if (x % l == 0) isFact.get(l).add(x);
            long ct = 0;
            for (long x : fact.keySet()) if (l % x == 0) ct++;
            numFacts.put(l, ct);
            fact.put(l, modInverse(fact.size(), MOD));
        }
        if (k == 0) {
            System.out.println(n);
            return;
        }
        for (int i = 1; i < k; i++) {
            HashMap<Long, Long> temp = new HashMap<>();
//            HashMap<Long, Long> b = new HashMap<>();
            for (long l : fact.keySet()) {
                for (long x : fact.keySet()) {
                    if (isFact.get(l).contains(x)) {
//                        a.putIfAbsent(l, 0L);
//                        b.putIfAbsent(l, 1L);
                        long len = numFacts.get(x);
                        temp.putIfAbsent(l, 0L);
                        temp.put(l, (temp.get(l) + fact.get(x) * modInverse(len, MOD)) % MOD);

//
//                        long d = lcm(b.get(l), den.get(x)*len);
//                        try {
//                            a.put(l, ((a.get(l) * (d / b.get(l))) % MOD + (num.get(x) * (d / (den.get(x) * len))) % MOD) % MOD);
//                        } catch (Exception e) {
//                            System.out.println();
//                            d = lcm(b.get(l), den.get(x)*len);
//                        }
//                        b.put(l, d);
                    }
                }
            }
            fact = temp;
//            num = a;
//            den = b;
//            for (Long l : num.keySet()) {
//                long gcd = gcd(num.get(l), den.get(l));
//                num.put(l, num.get(l) / gcd);
//                den.put(l, den.get(l) / gcd);
//            }
        }
        long ans = 0;
        for (Long l : fact.keySet()) {
            ans = (ans + (l * fact.get(l)) % MOD) % MOD;
        }
        System.out.println(ans);

//        long lcm = 1;
//        for (Long d : den.values()) {
//            lcm = lcm(lcm, d);
//        }
//        long ans = 0;
//        long inv = modInverse(lcm, MOD);
//        for (Long l : num.keySet()) {
//            long temp = (num.get(l) * (lcm / den.get(l))) % MOD;
//            temp = (temp * l) % MOD;
//            temp = (temp * inv) % MOD;
//            ans = (ans + temp) % MOD;
//        }
//        System.out.println(ans);
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

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

}
