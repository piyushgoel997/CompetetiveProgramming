import java.util.Arrays;
import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        T = s.nextInt();
        long[] t = new long[n];
        for (int i = 0; i < n; i++) {
            t[i] = s.nextLong();
        }
        System.out.println(solve(t));
    }
    static int a,b,c,n,T;

    private static long solve(long[] t) {
        long ans = t.length * a;
        if (b >= c) {
            return ans;
        } else {
            Arrays.sort(t);
            for (int i = 0; i < t.length; i++) {
                if (t[i] > T) {
                    break;
                }
                ans += (T - t[i]) * (c - b);
            }
            return ans;
        }
    }

}
