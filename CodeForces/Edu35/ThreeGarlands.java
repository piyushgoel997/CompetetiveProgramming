import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 28-12-2017 at 20:04.
 */
public class ThreeGarlands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        Arrays.sort(a);
        if (a[0] == 1) {
            System.out.println("YES");
        } else if (a[0] == 2) {
            if (a[1] == 2 || (a[1] == 4 && a[2] == 4))
                System.out.println("YES");
            else System.out.println("NO");
        } else if (a[0] == 3 && a[1] == 3 && a[2] == 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
