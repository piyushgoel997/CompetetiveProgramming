import java.util.Scanner;

/**
 * Created by piyus on 15-07-2017 at 15:52.
 * HP Think A Thon. 4. correct for small inputs.
 */
public class MatrixCloneJutsu {

    static final long MOD = 1000000007;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        long k = s.nextLong();
        k = fact(k);
        long[][] mat = new long[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = s.nextInt();
            }
        }
        long sum = sum(mat);
        long sp = sum;
        long sc = sum;
        long beta = (M * N) % MOD;
        for (long i = 1; i < k; i++) {
            sc = ((sp) % MOD + (beta * sp) % MOD + sum % MOD) % MOD;
            sp = sc;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(((mat[i][j]%MOD) + sc%MOD)%MOD);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static long fact(long k) {
        long ans = 1;
        for (long i = 2; i <= k; i++) {
            ans = ((ans % MOD) * (i % MOD)) % MOD;
        }
        return ans;
    }

    static long sum(long[][] mat) {
        long sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum = ((sum % MOD) + (mat[i][j] % MOD)) % MOD;
            }
        }
        return sum;
    }
}
