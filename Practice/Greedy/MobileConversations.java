package Greedy;

import java.util.Scanner;

/**
 * Created by piyus on 25-07-2017 at 21:31.
 * Hacker Earth
 */
public class MobileConversations {
    //TODO not yet correct. try again. // 6262381 correct ans for inp 1
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] t = new long[n];
        long[] x = new long[n];
        t[0] = s.nextLong();
        x[0] = s.nextLong();
        for (int i = 1; i < n; i++) {
            t[i] = t[i - 1] + s.nextLong();
            x[i] = x[i - 1] + s.nextLong();
        }
        long m = 0;
        for (int i = 0; i < n - 1; i++) {
            long temp = (t[i + 1] - t[i]) - (m + x[i] - t[i]);
            if (temp > 0) {
                m += temp;
            }
        }
        System.out.println(m);
    }
}
