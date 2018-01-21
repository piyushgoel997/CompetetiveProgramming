import java.util.Scanner;

/**
 * Created by piyus on 28-12-2017 at 19:46.
 */
public class TwoCakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int max = -1;
        for (int i = Math.max(n - b , 1); i <= Math.min(a, n - 1); i++) {
            max = Math.max(max, Math.min(a / i, b / (n - i)));
        }
        System.out.println(max);

    }
}
