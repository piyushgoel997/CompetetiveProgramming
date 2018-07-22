import java.util.Scanner;

/**
 * Created by piyus on 02-12-2017 at 19:50.
 */
public class ChthollysRequest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(sumOfKSmallestZCYNos(s.nextInt(), s.nextLong()));
    }

    private static long sumOfKSmallestZCYNos(int k, long p) {
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            long zcy = getZCY(i) % p;
            ans = (ans + zcy) % p;
        }
        return ans;
    }

    private static long getZCY(int i) {
        char[] fwd = String.valueOf(i).toCharArray();
        char[] rev = new char[fwd.length];
        for (int j = 0; j < fwd.length; j++) {
            rev[j] = fwd[fwd.length - 1 - j];
        }
        return (Long.parseLong(String.valueOf(fwd)) * (long) Math.pow(10, fwd.length)) + Long.parseLong(String.valueOf(rev));
    }
}
