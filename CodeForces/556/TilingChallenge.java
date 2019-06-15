import java.util.Scanner;

public class TilingChallenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] filled = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = s.next();
            for (int j = 0; j < n; j++) {
                filled[i][j] = (str.charAt(j) == '#');
            }
        }
        boolean impossible = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!filled[i][j]) {
                    if (j - 1 < 0 || (i + 2 >= n || j + 1 >= n)) {
                        impossible = true;
                        break;
                    }
                    if (filled[i + 1][j] || (filled[i + 1][j - 1] || (filled[i + 1][j + 1] || filled[i + 2][j]))) {
                        impossible = true;
                        break;
                    }
                    filled[i + 1][j] = true;
                    filled[i + 1][j - 1] = true;
                    filled[i + 1][j + 1] = true;
                    filled[i + 2][j] = true;
                }
            }
            if (impossible) break;
        }
        if (impossible) System.out.println("NO");
        else System.out.println("YES");
    }
}
