import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Piyush on 6/12/2017.
 * Kickstart Practice Round 2 2017 B.
 * not correct yet.
 */
public class WatsonAndIntervals {
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
        // N, L1, R1, A, B, C1, C2, and M
        //take inputs
        int n = s.nextInt();
        long l1 = s.nextLong();
        long r1 = s.nextLong();
        long a = s.nextLong();
        long b = s.nextLong();
        long c1 = s.nextLong();
        long c2 = s.nextLong();
        long m = s.nextLong();
        long[] low = new long[n];
        long[] high = new long[n];
        long x = l1;
        long y = r1;
        // make intervals
        for (int i = 0; i < n; i++) {
            if (x < y) {
                low[i] = x % m;
                high[i] = y % m;
            } else {
                low[i] = y % m;
                high[i] = x % m;
            }
            long xnew = (((a % m) * (x % m)) % m) + (((b % m) * (y % m)) % m) + (c1 % m);
            long ynew = (((a % m) * (y % m)) % m) + (((b % m) * (x % m)) % m) + (c2 % m);
            x = xnew % m;
            y = ynew % m;
        }

        long[] cornerPoints = new long[2 * n];
        for (int i = 0; i < n; i++) {
            cornerPoints[i] = low[i];
        }
        for (int i = 0; i < n; i++) {
            cornerPoints[i + n] = high[i];
        }
        Arrays.sort(cornerPoints);

        long[] indepLen = new long[n];
        for (int i = 0; i < n; i++) {
            indepLen[i] = 0;
        }
        long overlappingLen = 0;
        for (int i = 0; i < cornerPoints.length - 1; i++) {
            int interval = -1;
            double pt = (cornerPoints[i]*1.0 + cornerPoints[i + 1]) / 2;
            for (int j = 0; j < n; j++) {
                if (pt <= high[j] && pt >= low[j]) {
                    if (interval != -1) {
                        interval = -1;
                        break;
                    }
                    interval = j;
                }
            }
            if (interval != -1) {
                indepLen[interval] += cornerPoints[i + 1] + 1 - cornerPoints[i];
            } else {
                overlappingLen += cornerPoints[i + 1] - cornerPoints[i] - 1;
            }
        }
        long totalLength = 0;
        for (int i = 0; i < indepLen.length - 1; i++) {
            totalLength += indepLen[i];
        }
        totalLength += overlappingLen;
        return totalLength + 1 - maxIn(indepLen);
    }

    private static long maxIn(long[] indepLen) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < indepLen.length; i++) {
            if (indepLen[i] > max) {
                max = indepLen[i];
            }
        }
        return max;
    }

    private static long totalLen(long[] low, long[] high) {
        Arrays.sort(low);
        Arrays.sort(high);
        int i = 0;
        int j = 0;
        int start = 0;
        long len = 0;
        while (i < low.length && j < high.length) {
            while (i < low.length && low[i + 1] < high[j]) {
                i++;
            }
            if (i < low.length) {
                while (j < high.length && high[j] < low[i + 1]) {
                    j++;
                }
            } else {
                while (j < high.length) {
                    j++;
                }
            }
            len += high[j - 1] - low[start] + 1;
            start = i;
        }
        return len;
    }
}
