package NumberTheory;

import java.util.Scanner;

/**
 * Created by piyus on 26-07-2017 at 17:13.
 * CodeChef
 */
public class PrimeGenerator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int m = s.nextInt();
            int n = s.nextInt();
            boolean[] isPrime = new boolean[n + 1];
            for (int j = 0; j <= n; j++) {
                isPrime[j] = true;
            }
            isPrime[0] = false;
            isPrime[1] = false;
            for (int j = 2; j * j <= n; j++) {
                if (isPrime[j])
                    for (int k = 2 * j; k <= n; k += j) {
                        isPrime[k] = false;
                    }
            }
            for (int j = m; j <= n; j++) {
                if (isPrime[j]) {
                    System.out.println(j);
                }
            }
            System.out.println();
        }
    }
}
