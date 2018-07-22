import java.util.Arrays;
import java.util.Scanner;

public class TwoSquares {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] px = new int[4];
        int[] py = new int[4];
        int[] bx = new int[4];
        int[] by = new int[4];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) px[i / 2] = s.nextInt() + 100;
            else py[i / 2] = s.nextInt() + 100;
        }
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) bx[i / 2] = s.nextInt() + 100;
            else by[i / 2] = s.nextInt() + 100;
        }
        int[] cpx = Arrays.copyOf(px, 4);
        Arrays.sort(cpx);
        int[] cpy = Arrays.copyOf(py, 4);
        Arrays.sort(cpy);
        int pl = cpx[0];
        int pr = cpx[3];
        int pt = cpy[3];
        int pb = cpy[0];
        int[] cbx = Arrays.copyOf(bx, 4);
        Arrays.sort(cbx);
        int[] cby = Arrays.copyOf(by, 4);
        Arrays.sort(cby);
        int bl = cbx[0];
        int bmx = cbx[1];
        int br = cbx[3];
        int bb = cby[0];
        int bmy = cby[1];
        int bt = cby[3];

        for (int i = 0; i < 4; i++) {
            // any vertex of 2nd in 1st
            int x = bx[i];
            int y = by[i];
            if (x <= pr && x >= pl && y <= pt && y >= pb) {
                System.out.println("YES");
                return;
            }
        }

//        if (bb == bt) {
//            System.out.println("NO");
//            return;
//        }

//        int bxmid = (br + bl) / 2;
//        int bymid = (bb + bt) / 2;
//
//        bl = bl - bxmid;
//        br = br - bxmid;
//
//        bt = bt - bymid;
//        bb = bb - bymid;
//
//        for (int i = 0; i < 4; i++) {
//            px[i] -= bxmid;
//            py[i] -= bymid;
//        }
//        for (int i = 0; i < 4; i++) {
//            int x = px[i];
//            int y = py[i];
//            if (((1.0 * x) / br) + ((1.0 * y) / bt) <= 1 && ((1.0 * x) / bl) + ((1.0 * y) / bb) <= 1
//                    && ((1.0 * x) / br) + ((1.0 * y) / bb) <= 1 && ((1.0 * x) / bl) + ((1.0 * y) / bt) <= 1) {
//                System.out.println("YES");
//                return;
//            }
//        }

        for (int i = 0; i < 4; i++) {
            // any vertex of 1st in 2nd
            int x = px[i];
            int y = py[i];
            if (((x + y) >= (bl + bmx + bb + bmy) / 2) && ((x + y) <= (bmx + br + bmy + bt) / 2)
                    && almostEqual(dist(x,y,bmx,bb,br,bmy) + dist(x,y,bmx,bt,bl,bmy), Math.sqrt(Math.pow(bmx - br, 2) + Math.pow(bt - bmy, 2)), 0.01)) {
//                System.out.println(x);
//                System.out.println(y);
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static double dist(int x, int y, int x1, int y1, int x2, int y2) {
        double num = Math.abs(x * (y2 - y1) + y * (x1 - x2) - x1 * y2 + x2 * y1);
        double den = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return num / den;
    }

    public static boolean almostEqual(double a, double b, double eps){
        return Math.abs(a-b)<eps;
    }
}
