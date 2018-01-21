import java.util.Scanner;

/**
 * Created by piyus on 16-12-2017 at 17:31.
 */
public class FactArr {
    private static long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 227020800, 178291200, 674368000, 789888000, 428096000, 705728000, 408832000, 176640000, 709440000, 607680000, 976640000, 439360000, 984000000, 584000000, 768000000, 504000000, 616000000, 480000000, 880000000, 160000000, 280000000, 520000000, 200000000, 200000000, 400000000, 200000000, 800000000};
    private static final long MOD = 1000000000;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] A = new long[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextLong();
        }

    }
}
