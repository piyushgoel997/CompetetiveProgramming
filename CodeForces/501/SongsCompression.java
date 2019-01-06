import java.util.Arrays;
import java.util.Scanner;

public class SongsCompression {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] diff = new int[n];
        int sum = 0;
        int diffSum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            diff[i] = a - b;
            diffSum += diff[i];
            sum += a;
        }
        if (sum - diffSum > m) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(diff);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sum <= m) break;
            sum -= diff[i];
            count++;
        }
        if (sum <= m) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
