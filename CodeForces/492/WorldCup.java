import java.util.Scanner;

public class WorldCup {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] a = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++){
            a[i] = s.nextLong();
            min = Math.min(min, a[i]);
        }

        if (min >= n) {
            long x = (min / n) * n;
            for (int i = 0; i < n; i++) {
                a[i] -= x;
            }
        }

        int idx = 0;
        if (a[idx] <= 0) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < n; i++) {
            a[i] -= i;
            if (a[i] < a[idx]) idx = i;
            if (a[i] <= 0) break;
        }
        System.out.println(idx + 1);
    }
}
