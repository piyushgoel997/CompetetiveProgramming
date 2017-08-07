package Greedy;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 25-07-2017 at 19:46.
 * Hacker Earth
 */
public class ArraysForce {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long t = s.nextLong();
        for (int i = 0; i < t; i++) {
            long zero = s.nextLong();
            long one = s.nextLong();
            long n = s.nextLong();
            long mod = s.nextLong();
            HashMap<Long, Long> map = new HashMap<>();
            if (zero != one) {
                map.put(zero, (long) 1);
                map.put(one, (long) 1);
            } else {
                map.put(zero, (long) 2);
            }
            for (int j = 0; j < n - 2; j++) {
                long curr = zero + one;
                curr = curr % mod;
                zero = one;
                one = curr;
                if (map.containsKey(curr)) {
                    map.put(curr, map.get(curr) + 1);
                } else {
                    map.put(curr, (long) 1);
                }
            }
            long ans = 0;
            for (long k : map.values()) {
                ans += k * k;
            }
            System.out.println(ans);
        }
    }
}
