import java.util.Scanner;

public class Candies {
    public static void main(String[] args) {
        long n = (new Scanner(System.in)).nextLong();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        long start = 0;
        long end = n;
        long ans = n;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (check(n, mid)) {
                end = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                start = mid + 1;
            }
        }
        if (ans == 0) ans++;
        System.out.println(ans);
    }

    private static boolean check(final long n, long k) {
        long tempN = n;
        long eaten = 0;
        while (tempN >= k) {
            tempN -= k;
            eaten += k;
            if (tempN < 10) {
                break;
            }
            tempN -= (tempN / 10);
        }
        eaten += tempN;
        return eaten >= ((n + 1) / 2);
    }


}
