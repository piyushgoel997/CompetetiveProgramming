import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 16-12-2017 at 16:56.
 */
public class FactorialArray3 {

    private static long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 227020800, 178291200, 674368000, 789888000, 428096000, 705728000, 408832000, 176640000, 709440000, 607680000, 976640000, 439360000, 984000000, 584000000, 768000000, 504000000, 616000000, 480000000, 880000000, 160000000, 280000000, 520000000, 200000000, 200000000, 400000000, 200000000, 800000000};
    private static final long MOD = (long) 1e9;
    private static long[] segTree;
    private static int[] leftIdx;
    private static int[] rightIdx;
    private static int[] A;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        segTree = new long[2 * n + 1];
        leftIdx = new int[2 * n + 1];
        rightIdx = new int[2 * n + 1];
        Arrays.fill(leftIdx, -1);
        Arrays.fill(rightIdx, -2);
        constructFactSegTree(1, A, 0, n - 1);
        for(int a0 = 0; a0 < m; a0++){
            int q = in.nextInt();
            if (q == 1) {
                first(1, in.nextInt() - 1, in.nextInt() - 1);
            } else if (q == 2) {
                System.out.println(second(1, in.nextInt() - 1, in.nextInt() - 1));
            } else {
                third(1, in.nextInt() - 1, in.nextInt());
            }
        }
        in.close();
    }


    private static long fact(int x) {
        if (x >= 40) return 0;
        else return factorials[x];
    }

    private static long third(int x, int i, int v) {
        if (x >= segTree.length) return 0;
        if (leftIdx[x] == rightIdx[x] && leftIdx[x] == i) {
            A[leftIdx[x]] = v;
            return segTree[x] = fact(v);
        }
        if (i >= leftIdx[x] && i <= rightIdx[x]) {
            segTree[x] = (third(2 * x, i, v) + third(2 * x + 1, i, v)) % MOD;
        }
        return segTree[x];
    }

    private static long second(int x, int l, int r) {
        if (x >= segTree.length) return 0;
        if (r < leftIdx[x] || l > rightIdx[x]) return 0;
        if (r >= leftIdx[x] && l <= rightIdx[x]) return segTree[x];
        return (second(2 * x, l, r) + second(2 * x + 1, l, r)) % MOD;
    }

    private static long first(int x, int l, int r) {
        if (x >= segTree.length) return 0;
        if (leftIdx[x] == rightIdx[x] && leftIdx[x] >= l && rightIdx[x] <= r) {
            return segTree[x] = fact(++A[leftIdx[x]]);
        }
        if (r < leftIdx[x] || l > rightIdx[x]) {
            return segTree[x];
        }
        return segTree[x] = (first(2 * x, l, r) + first(2 * x + 1, l, r)) % MOD;
    }

    private static long constructFactSegTree(int x, int[] arr, int i, int j) { // both inclusive
        if (x >= segTree.length) return 0;
        leftIdx[x] = i;
        rightIdx[x] = j;
        if (i == j) {
            return segTree[x] = fact(arr[i]);
        }
        return segTree[x] = (constructFactSegTree(2 * x, arr, i, i + (j - i) / 2) + constructFactSegTree(2 * x + 1, arr, i + 1 + (j - i) / 2, j)) % MOD;
    }

    /*
2
6
24
120
720
5040
40320
362880
3628800
39916800
479001600
227020800
178291200
674368000
789888000
428096000
705728000
408832000
176640000
709440000
607680000
976640000
439360000
984000000
584000000
768000000
504000000
616000000
480000000
880000000
160000000
280000000
520000000
200000000
200000000
400000000
200000000
800000000
     */
}
