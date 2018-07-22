import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by piyus on 12-03-2018 at 20:15.
 */
public class MinimumFiboSum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long k = s.nextLong();
        System.out.println(minNoOfFibTerms(k));
    }

    private static int minNoOfFibTerms(long K) {
        // list of fibonacci terms <= K.
        List<Long> fibTerms = new ArrayList<>();
        fibTerms.add(1L);
        fibTerms.add(1L);
        int i = 2;
        while (true) {
            fibTerms.add(fibTerms.get(i - 1) + fibTerms.get(i - 2));
            if (fibTerms.get(i) >= K) break;
            i++;
        }

        // actual task of count the the number of Fibonacci terms required.
        int count = 0;
        long k = K; // temporary variable
        for (i = fibTerms.size() - 1; i >= 0 && k > 0; i--) {
            // Divide sum K by the i-th Fibonacci term to find how many terms it contribute in sum.
            count += k / fibTerms.get(i);
            // Removing the part of sum contributed by the i-th Fibonacci term.
            k %= fibTerms.get(i);
        }
        return count;
    }
}
