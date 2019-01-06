import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class SphereTransmission {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        HashSet<Long> set = new HashSet<>();
        set.add((n * (n + 1)) / 2);
        set.add(1L);
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i != 0) continue;
            long x = (n / i) - 1;
            if (x != 0) set.add(i * ((x * (x + 1)) / 2) + x + 1);
            x = i - 1;
            if (x != 0) set.add((n / i) * ((x * (x + 1)) / 2) + x + 1);
        }
        ArrayList<Long> list = new ArrayList<>(set);
        Collections.sort(list);
//        System.out.println(list.size());
        for (Long aList : list) System.out.print(aList + " ");
    }
}
