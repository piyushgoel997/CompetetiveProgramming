package BitManipulation;

import java.util.Scanner;

/**
 * Created by piyus on 21-08-2017 at 00:05.
 * HackerRank. BitManipulation - Easy. Correct.
 */
public class FlippingBits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(flipBits(s.nextLong()));
        }
    }

    private static long flipBits(final long n) {
        long temp = n;
        long pow = 1;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += ((temp % 2) ^ 1) * pow;
            temp = temp / 2;
            pow *= 2;
        }
        return ans;
    }
}
