package DecEasy17;

import java.util.Scanner;

/**
 * Created by piyus on 01-12-2017 at 22:01.
 */
public class ContriFromDiv {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        for (int q = 0; q < Q; q++) {
            System.out.println(G(s.nextInt()));
        }
    }

    private static long G(int x) {
        StringBuilder sb = new StringBuilder().append(x);
        for (int i = 1; i <= x / 2; i++) {
            if (x % i == 0) {
                sb.append(i);
            }
        }
        long ans = 0;
        for (char c : sb.toString().toCharArray()) {
            int i = Integer.parseInt(String.valueOf(c));
            if ((i + 2) % 2 != 0) {
                ans += i;
            }
        }
        return ans;
    }


//    private static long[] fs;
//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int Q = s.nextInt();
//        fs = new long[1000001];
//        for (int i = 0; i < fs.length; i++) fs[i] = -1;
//        for (int q = 0; q < Q; q++) {
//            int n = s.nextInt();
//            System.out.println(G(n));
//        }
//    }
//
//    private static long G(int n) {
//        long ans = 0;
//        for (int i = 1; i <= n / 2; i++) {
//            if (n % i == 0) {
//                ans += f(i);
//            }
//        }
//        ans += f(n);
//        return ans;
//    }
//
//    private static long f(int x) {
//        if (x <= 0) return 0;
//        if (fs[x] != -1) return fs[x];
//        int a = x % 10;
//        if (a % 2 == 0) {
//            a = 0;
//        }
//        return fs[x] = a + f(x / 10);
//    }

//    private static long f(final int i) {
//        if (fs[i] != -1) return fs[i];
//        long ans = 0;
//        int x = i;
//        while (x > 0) {
//            int a = x % 10;
//            x /= 10;
//            if (a % 2 != 0) {
//                ans += a;
//            }
//        }
//        return fs[i] = ans;
//    }
}
