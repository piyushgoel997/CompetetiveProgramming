import java.util.Scanner;

/**
 * Created by piyus on 28-12-2017 at 19:35.
 */
public class NearestMinimums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            min = Math.min(min, arr[i]);
        }
        int d = n;
        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            long l = arr[i];
            if (l == min) {
                if (prev == -1) {
                    prev = i;
                    continue;
                }
                d = Math.min(d, i - prev);
                prev = i;
            }
        }
        System.out.println(d);
    }
}
