import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 15-12-2017 at 00:21.
 */
public class FactorialArray2 {

    private static long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 227020800, 178291200, 674368000, 789888000, 428096000, 705728000, 408832000, 176640000, 709440000, 607680000, 976640000, 439360000, 984000000, 584000000, 768000000, 504000000, 616000000, 480000000, 880000000, 160000000, 280000000, 520000000, 200000000, 200000000, 400000000, 200000000, 800000000};
    private static final long MOD = 1000000000;
    private static long[] segTree;
    private static int[] leftIdx;
    private static int[] rightIdx;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] A = new long[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextLong();
        }
        segTree = new long[2 * n + 1];
        leftIdx = new int[2 * n + 1];
        rightIdx = new int[2 * n + 1];
        Arrays.fill(leftIdx, -1);
        Arrays.fill(rightIdx, -2);
        makeSegTree(1, 0, n - 1, A);
        for (int op = 0; op < m; op++) {
            int q = in.nextInt();
            switch (q) {
                case 1:
                    first(1, in.nextInt() - 1, in.nextInt() - 1, A);
                    break;
                case 2:
                    System.out.println(second(1, in.nextInt() - 1, in.nextInt() - 1));
                    break;
                case 3:
                    third(1, in.nextInt() - 1, in.nextLong(), A);
                    break;
            }
        }
    }

    private static long first(int x, int l, int r, long[] a) {
        if (x >= segTree.length) return 0;
        if (leftIdx[x] > r || rightIdx[x] < l) return segTree[x];
        if (leftIdx[x] == rightIdx[x] && leftIdx[x] >= l && leftIdx[x] <= r) {
            a[leftIdx[x]] = a[leftIdx[x]] + 1;
            return segTree[x] = fact(a[leftIdx[x]]);
        }
        return segTree[x] = first(2 * x, l, r, a) + first(2 * x + 1, l, r, a);
    }

    private static long second(int x, int l, int r) {
        if (x >= segTree.length) return 0;
        if (leftIdx[x] > r || rightIdx[x] < l) return 0;
        if (leftIdx[x] >= l && rightIdx[x] <= r) return segTree[x];
        return second(2 * x, l, r) + second(2 * x + 1, l, r);
    }

    private static long third(int x, int i, long v, long[] a) {
        if (x >= segTree.length) return 0;
        if (i > rightIdx[x] || i < leftIdx[x]) return segTree[x];
        if (leftIdx[x] == rightIdx[x] && leftIdx[x] == i) {
            a[i] = v;
            return segTree[x] = fact(a[i]);
        }
        return segTree[x] = (third(2 * x, i, v, a) + third(2 * x + 1, i, v, a)) % MOD;
    }

    private static long makeSegTree(int x, int l, int r, long[] a) {
        if (x >= segTree.length) return 0;
        if (l == r) {
            leftIdx[x] = l;
            rightIdx[x] = l;
            return segTree[x] = fact(a[l]);
        }
        leftIdx[x] = l;
        rightIdx[x] = r;
        return segTree[x] = (makeSegTree(2 * x, l, l + (r - l) / 2, a) + makeSegTree(2 * x + 1, l + 1 + (r - l) / 2, r, a)) % MOD;
    }

    private static long fact(long x) {
        if (x >= 40) return 0;
        else return factorials[(int)x];
    }
}
