package BitManipulation;

import java.util.Scanner;

/**
 * Created by piyus on 21-08-2017 at 19:27.
 * HackerRank. BitManipulation - Medium. Both Correct.
 */
public class AndProduct {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(bitwiseAndRange1(s.nextLong(), s.nextLong()));
        }
    }

    // O(n) solution
    private static long bitwiseAndRangeN(long a, long b) {
        long ans = a;
        for (long i = a; i <= b; i++) {
            ans = ans & i;
        }
        return ans;
    }

    // O(1) solution
    private static long bitwiseAndRange1(long a, long b) {
        String aBin = Long.toBinaryString(a);
        String bBin = Long.toBinaryString(b);
        bBin = bBin.substring(bBin.length() - aBin.length());
        int i = 0;
        while (i < aBin.length() && aBin.charAt(i) == bBin.charAt(i)) i++;
        StringBuilder ans = new StringBuilder(bBin.substring(0, i));
        for (; i < bBin.length(); i++) ans.append("0");
        return Long.parseLong(String.valueOf(ans), 2);
    }

}
