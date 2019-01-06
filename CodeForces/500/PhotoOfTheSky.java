import java.util.Arrays;
import java.util.Scanner;

public class PhotoOfTheSky {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] a = new long[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = s.nextLong();
        }
        Arrays.sort(a);
        long minArea = Math.abs((a[0] - a[n - 1]) * (a[n] - a[2 * n - 1]));
        long deltaY = a[2 * n - 1] - a[0];
        for (int i = 1; i < n; i++) {
            long x1 = a[i];
            long x2 = a[i + n - 1];
            minArea = Math.min(minArea, Math.abs((x1 - x2) * deltaY));
        }
        System.out.println(minArea);
    }
}
