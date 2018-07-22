import java.util.Scanner;

/**
 * Created by piyus on 27-06-2017 at 12:01.
 * Kickstart Round C 2017 B.
 */
public class XSquared {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            String ans = solve(n);
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static String solve(int n) {
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.next();
        }
        boolean flag = false;
        int A = -1;
        int B = -1;
        for (int i = 0; i < n; i++) {
            int ct = 0;
            int a = -1, b = -1;
            for (int j = 0; j < n; j++) {
                if (str[i].charAt(j) == 'X') {
                    ct++;
                    a = i;
                    b = j;
                }
            }
            if (!flag && ct == 1) {
                flag = true;
                A = a;
                B = b;
            }
            else if (flag && ct == 1) {
                return "IMPOSSIBLE";
            }
            else if (ct != 2) {
                return "IMPOSSIBLE";
            }
        }

        flag = false;
        for (int j = 0; j < n; j++) {
            int ct = 0;
            int a = -1, b = -1;
            for (int i = 0; i < n; i++) {
                if (str[i].charAt(j) == 'X') {
                    ct++;
                    a = i;
                    b = j;
                }
            }
            if (!flag && ct == 1) {
                flag = true;
                if (!(A == a && B == b)) {
                    return "IMPOSSIBLE";
                }
            }
            else if (flag && ct == 1) {
                return "IMPOSSIBLE";
            }
            else if (ct != 2) {
                return "IMPOSSIBLE";
            }
        }


        for (int i = 0; i < n; i++) {
            if (i == A) {
                continue;
            }
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (str[i].equals(str[j])) {
                    if (!found) {
                        found = true;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
            if (!found) {
                return "IMPOSSIBLE";
            }
        }


        return "POSSIBLE";
    }
}
