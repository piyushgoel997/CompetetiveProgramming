import java.util.Scanner;

public class TurnTheRectangles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] w = new long[n];
        long[] h = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = s.nextLong();
            h[i] = s.nextLong();
        }
        long curr = 0;
        for (int i = n - 1; i >= 0; i--) {
            long min = Math.min(w[i], h[i]);
            long max = Math.max(w[i], h[i]);
            if (min >= curr) {
                curr = min;
            } else if (curr > max) {
                System.out.println("NO");
                return;
            } else {
                curr = max;
            }
        }
        System.out.println("YES");
    }
}
