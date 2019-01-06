import java.util.HashSet;
import java.util.Scanner;

public class Border {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        long[] a = new long[n];
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = s.nextLong();
            set.add(a[i] % k);
            for (int j = 1; j % k == 0 || (j * a[i]) % k != 0; j++) {
                set.add((a[i] * j) % k);
            }
//            if (set.contains(1L)) {
//                System.out.println(k + 1);
//                for (int j = 0; j <= k; j++) {
//                    System.out.print(j+" ");
//                }
//                return;
//            }
        }
        if (set.size() > k) {
            System.out.println(set.size());
            for (long i : set) {
                System.out.print(i + " ");
            }
            return;
        }
        HashSet<Long> comb = new HashSet<>();
        for (long i : set) {
            for (long j : set) {
                comb.add((i + j) % k);
                for (int x = 1; x % k == 0 || (x * (i + j)) % k != 0; j++) {
                    comb.add((x * (i + j)) % k);
                }
            }
        }
        set.addAll(comb);
//        comb = new HashSet<>();
//        for (long i : set) {
//            for (long j : set) {
//                comb.add((i + j) % k);
//                for (int x = 1; x % k == 0 || (x * (i + j)) % k != 0; j++) {
//                    comb.add((x * (i + j)) % k);
//                }
//            }
//        }
        System.out.println(set.size());
        for (long l : set) {
            System.out.print(l+" ");
        }
    }
}
