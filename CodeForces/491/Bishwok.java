import java.util.Scanner;

public class Bishwok {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] b = new String[2];
        b[0] = s.next();
        b[1] = s.next();
        table = new int[3][b[0].length()];
        System.out.println(dp(b, 0, -1));
    }

    private static int[][] table;

    private static int dp(String[] b, int idx, int anyX) {
        if (idx >= b[0].length() - 1) return 0;
        if (table[anyX + 1][idx] != 0) return table[anyX + 1][idx];
        char up = b[0].charAt(idx);
        char low = b[1].charAt(idx);
        if (anyX == 0) up = 'X';
        if (anyX == 1) low = 'X';
        int ans = 0;
        if (up == low) {
            if (up == '0') {
                if (b[0].charAt(idx + 1) == '0') {
                    ans = Math.max(ans, 1 + dp(b, idx + 1, 0));
                }
                if (b[1].charAt(idx + 1) == '0') {
                    ans = Math.max(ans, 1 + dp(b, idx + 1, 1));
                }
            }
        } else {
            if (b[0].charAt(idx + 1) == '0' && b[1].charAt(idx + 1) == '0') {
                ans = Math.max(ans, 1 + dp(b, idx + 2, -1));
            }
        }
        ans = Math.max(ans, dp(b, idx + 1, -1));
        return table[anyX + 1][idx] = ans;
    }
}
