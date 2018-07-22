import java.util.Scanner;

/**
 * Created by piyus on 23-12-2017 at 19:38.
 */
public class MashaAndBears {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int f = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int a = in.nextInt();
        // a <= son_car
        // son_car <= 2*a


//        for (int fc = Math.max(a,f); fc <= 2 * fc; fc++) {
//            for (int mc = Math.max(a, m); mc <= Math.min(2 * m, f - 1); mc++) {
//                for (int sc = Math.max(a, s); sc <= Math.min(2 * s, m - 1); sc++) {
//                    if (2 * a >= s && 2 * a < f && 2 * a < m) {
//                        System.out.println(fc);
//                        System.out.println(mc);
//                        System.out.println(sc);
//                        return;
//                    }
//                }
//            }
//        }
//        System.out.println(-1);
//        return;



        int sc = a;
        for (; sc <= Math.min(2*a, m); sc++) {
            // masha likes
            if (sc <= 2 * s && sc >= s) {
                // son likes
                int mc = Math.max(m, sc + 1);
                mc = Math.max(mc, 2 * a + 1);
                for (; mc <= Math.min(2 * m,f); mc++) {
                    //mom likes
                    int fc = Math.max(mc + 1, f);
                    fc = Math.max(fc, 2 * a + 1);
                    if (fc <= 2 * f) {
                        // father likes
                        System.out.println(fc);
                        System.out.println(mc);
                        System.out.println(sc);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
