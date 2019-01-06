import java.util.Scanner;

public class Benches {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            max = Math.max(max, a[i]);
        }

        int left = m;
        int minK;
        for (int i = 0; i < n; i++) {
            if (left <= 0) break;
            left -= max - a[i];
        }
        minK = max + Math.max(0, (int) Math.ceil((1.0 * left) / n));

        int maxK = max + m;
        System.out.println(minK + " " + maxK);
    }
}
