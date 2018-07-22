import java.util.Scanner;

/**
 * Created by piyus on 27-12-2017 at 22:19.
 */
public class Segments {
    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();
        long ans = 0;
        int x = n / 2;
        ans += (x * (x + 1)) / 2;
        for (int i = (n / 2) + 1; i <= n; i++) {
            ans += n % i;
            ans++;
        }
        System.out.println(ans);
    }
}
