import java.util.Scanner;

public class DivTimesMod {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++) {
            if (n % i != 0) continue;
            ans = Math.min(ans, (n / i) * k) + i;
        }
        System.out.println(ans);
    }
}
