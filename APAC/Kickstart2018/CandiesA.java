import java.util.Scanner;

public class CandiesA {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int o = s.nextInt();
            long d = s.nextLong();
            long x1 = s.nextLong();
            long x2 = s.nextLong();
            long a = s.nextLong();
            long b = s.nextLong();
            long c = s.nextLong();
            long m = s.nextLong();
            long l = s.nextLong();
            System.out.println("Case #" + (t + 1) + ": " + solve(n, o, d, x1, x2, a, b, c, m, l));
        }
    }

    private static String solve(int n, int o, long d, long x1, long x2, long a, long b, long c, long m, long l) {
        if (d < 0) {
            l -= d;
            d = 0;
        }
        long[] candies = makeArray(n, x1, x2, a, b, c, m, l);
        int i = 0, j = 0;
        int currO = 0;
        long currS = 0;
        long maxSweet = Long.MIN_VALUE;
        while (j < n) {
            if (currO > o || currS > d) {
                while (currO > o || currS > d) {
                    if (Math.abs(candies[i] % 2) == 1) currO--;
                    currS -= candies[i];
                    i++;
                }
            } else {
                if (i!=j) maxSweet = Math.max(currS, maxSweet);
                currS += candies[j];
                if (Math.abs(candies[j]) % 2 == 1) currO++;
                j++;
            }
        }
        if (currS != 0 && currO <= o && currS <= d) maxSweet = Math.max(currS, maxSweet);
        if (maxSweet == Long.MIN_VALUE) return "IMPOSSIBLE";
        return "" + maxSweet;
    }

    private static long[] makeArray(int n, long x1, long x2, long a, long b, long c, long m, long l) {
        long[] candies = new long[n];
        a = (a + m) % m;
        b = (b + m) % m;
        c = (c + m) % m;
        candies[0] = x1 + l;
        candies[1] = x2 + l;
        for (int i = 2; i < n; i++) {

            candies[i] = a * x2 + b * x1 + c;
            candies[i] = candies[i] % m;
            x1 = x2;
            x2 = candies[i];
            candies[i] = candies[i] + l;

        }
        return candies;
    }
}
