import java.util.Scanner;

/**
 * Created by piyus on 12-06-2017 at 00:33.
 */
public class DiwaliLightings {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            long ans = solve();
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static long solve() {
        String pattern = s.next();
        long i = s.nextLong() - 1;
        long j = s.nextLong() - 1;
        long n = pattern.length();
        long times = (j - i) / n;
//        i = i % n;
//        j = j % n;
        long b = 0;
        for (int k = 0; k < n; k++) {
            if (pattern.charAt(k) == 'B') {
                b++;
            }
        }

        int k = (int) i - 1;
        long a = 0;
//        while (k != (int) j) {
//            k++;
//            if (k == n) {
//                k = 0;
//            }
//            if (pattern.charAt(k) == 'B') {
//                a++;
//            }
//        }
        long start = i % n;
        for (long l = 0; l <= (j - i) % n; l++) {
            long curr = start + l;
            curr = curr % n;
            if (pattern.charAt((int)curr) == 'B') {
                a++;
            }
        }
        return b * times + a;
    }


}
