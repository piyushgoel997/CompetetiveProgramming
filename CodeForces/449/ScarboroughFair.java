import java.util.Scanner;

/**
 * Created by piyus on 02-12-2017 at 19:37.
 */
public class ScarboroughFair {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        char[] str = s.next().toCharArray();
        for (int i = 0; i < m; i++) {
            op(str, s.nextInt() - 1, s.nextInt() - 1, s.next().charAt(0), s.next().charAt(0));
        }
        System.out.println(String.valueOf(str));
    }

    private static void op(char[] str, int l, int r, char c1, char c2) {
        for (int i = l; i <= r; i++) {
            if (str[i] == c1) {
                str[i] = c2;
            }
        }
    }
}
