import java.util.Arrays;
import java.util.Scanner;

public class PrefixSumPrimes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[] isPrime = primeSeive(4*n);
        int ones = 0;
        for (int i = 0; i < n; i++) if (s.nextInt() == 1) ones++;
        int twos = n - ones;

        int[] ans = new int[n];
        int curr = 0;
        int i = 0;
        int j = 0;
        while (ones > 0 || twos > 0) {
            while (!isPrime[i]) i++;
            if (i - curr >= 2 && twos != 0) {
                ans[j] = 2;
                twos--;
                j++;
                curr += 2;
            } else if (ones != 0) {
                ans[j] = 1;
                ones--;
                j++;
                curr += 1;
            } else {
                ans[j] = 2;
                twos--;
                j++;
                curr += 2;
            }
            if (curr == i) {
                i++;
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.print(ans[k]+" ");
        }
    }

    private static boolean[] primeSeive(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) for (int j = 2*i; j <= n; j += i) isPrime[j] = false;
        }
        isPrime[0] = false;
        if (n > 0) isPrime[1] = false;
        return isPrime;
    }

}
