import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Divisors {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextLong();
        }
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (long j = 2; j <= Math.cbrt(a[i]) + 1; j++) {
                // (long) Math.max(2, Math.pow(a[i], 0.2) - 1)
                if (a[i] % j == 0) {
                    map.putIfAbsent(j, 0L);
                    long ct = 0;
                    long temp = a[i];
                    while (temp != 1) {
                        temp /= j;
                        ct++;
                    }
                    map.put(j, map.get(j) + ct);
                }
            }
        }
        long ans = 1;
        for (Long l : map.keySet()) {
            ans = (ans * (map.get(l) + 1)) % 998244353;
        }
        System.out.println(ans);
    }
}
