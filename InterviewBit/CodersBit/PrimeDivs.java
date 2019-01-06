import java.util.ArrayList;
import java.util.Arrays;

public class PrimeDivs {
    public int solve(ArrayList<Integer> A, int B) {
        int max = 0;
        for (Integer aA1 : A) max = Math.max(aA1, max);
        boolean[] isPrime = primeSieve(max);
        int primeDivs = 0;
        for (Integer aA : A) {
            if (isPrime[aA]) if (B % aA == 0) primeDivs++;
        }
        return primeDivs;
    }

    private static boolean[] primeSieve(int x) {
        boolean[] isPrime = new boolean[x + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= x / 2; i++) {
            for (int j = 2*i; j <= x; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
