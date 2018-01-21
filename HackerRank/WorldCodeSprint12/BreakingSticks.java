import java.util.Scanner;

/**
 * Created by piyus on 14-12-2017 at 22:29.
 */
public class BreakingSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }

    private static long longestSequence(long[] a) {
        long count = 0;
        for (long i : a) {
            count += numOfMoves(i);
        }
        return count;
    }

    private static long numOfMoves(final long i) {
        long x = i;
        long moves = 1;
        while (x > 1) {
            moves += x;
            // find and divide by smallest factor
            long factor = 2;
            for (; factor < Math.sqrt(x); factor++) if (x % factor == 0) break;
            if (factor >= Math.sqrt(x)) x = 1;
            else x /= factor;
        }
        return moves;
    }
}
