import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NastyaStudiesInformatics {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int r = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int ct = 0;
        if (y % x != 0) {
            System.out.println(0);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < Math.sqrt(y); i++) {
            if (y % (i * x) == 0) {
                set.add(i);
                set.add(y / (i * x));
            }
        }
        for (int i : set) {
            int k = y / (i * x);
            int a = i * x;
            int b = k * x;
            if (Math.max(a, b) <= r && Math.min(a, b) >= l && gcd(i, k) == 1) ct++;
        }
        System.out.println(ct);
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}
