import java.util.Scanner;

/**
 * Created by piyus on 27-12-2017 at 22:27.
 */
public class PythonIndentation {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        char[] input = new char[n];
        for (int i = 0; i < n; i++) input[i] = s.next().charAt(0);
        dp = new long[n + 1][n + 1];
        System.out.println(fn(input, 0, 0, 's'));
    }

    private static long[][] dp;

    private static long fn(char[] chars, int idx, int levels, char prev) {
        if (idx >= chars.length) return dp[idx][levels] = 1;
        if (dp[idx][levels] != 0) return dp[idx][levels];
        if (chars[idx] == 's') return dp[idx][levels] = fn(chars, idx + 1, levels, 's');
        else {
            if (prev == 'f') {
                return dp[idx][levels] = fn(chars, idx + 1, levels + 1, 'f');
            } else {
                long ans = 0;
                for (int i = 1; i <= levels + 1; i++) {
                    ans = (ans + fn(chars, idx + 1, levels, 'f')) % MOD;
                    dp[idx][i] = ans;
                }
                return dp[idx][levels] = ans;
            }
        }
    }

}
