import java.util.Scanner;

/**
 * Created by Piyush on 19-01-2017.
 */
public class B1 {
    public static void main(String[] z) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        int n = input.length();
        char[] k = new char[4];
        for (int i = 0; i < n; i = i + 4) {
            if (input.charAt(i) != '!') {
                k[0] = input.charAt(i);
            }
        }
        for (int i = 1; i < n; i = i + 4) {
            if (input.charAt(i) != '!') {
                k[1] = input.charAt(i);
            }
        }
        for (int i = 2; i < n; i = i + 4) {
            if (input.charAt(i) != '!') {
                k[2] = input.charAt(i);
            }
        }
        for (int i = 3; i < n; i = i + 4) {
            if (input.charAt(i) != '!') {
                k[3] = input.charAt(i);
            }
        }

        int[] ans = new int[4];
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '!') {
                if (i % 4 == 0) {
                    ans[0] += 1;
                } else if (i % 4 == 1) {
                    ans[1] += 1;
                } else if (i % 4 == 2) {
                    ans[2] += 1;
                } else if (i % 4 == 3) {
                    ans[3] += 1;
                }
            }
        }
        int[] op = new int[4];
        for (int i = 0; i < 4; i++) {
            switch (k[i]) {
                case 'R':
                    op[0] = ans[i];
                    break;
                case 'B':
                    op[1] = ans[i];
                    break;
                case 'Y':
                    op[2] = ans[i];
                    break;
                case 'G':
                    op[3] = ans[i];
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(op[i] + " ");
        }
    }
}
