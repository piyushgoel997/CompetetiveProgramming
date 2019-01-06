import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class OptimizePrime {
    public static void main(String[] args) {
        System.out.println(solve(new Scanner(System.in).nextInt()));
    }

    private static final long MOD = 1000000007;

    public static long solve(int A) {
        map = new HashMap<>();
        return dp(A);
    }

    private static HashMap<Integer, Long> map;

    private static long dp(int A) {
        if (map.containsKey(A)) return map.get(A);
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                factors.add(i);
                factors.add(A / i);
            }
        }
        long ans = 1;
        for (int i : factors) {
            ans = (ans * i * dp(i)) % MOD;
        }
        map.put(A, ans);
        return ans;
    }
}
//756119104
