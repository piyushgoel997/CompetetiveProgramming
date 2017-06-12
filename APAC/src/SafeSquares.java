import java.util.Scanner;

/**
 * Created by Piyush on 6/12/2017.
 * Kickstart Practice Round 2 2017 B. Correct.
 * Refer this for help or better understanding -
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class SafeSquares {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            long ans = solve();
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static long solve() {
        int r = s.nextInt();
        int c = s.nextInt();
        int k = s.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = 1;
            }
        }
        for (int i = 0; i < k; i++) {
            grid[s.nextInt()][s.nextInt()] = 0;
        }
        int[][] counts = new int[r][c];
        for (int i = 0; i < c; i++) {
            counts[0][i] = grid[0][i];
        }
        for (int i = 0; i < r; i++) {
            counts[i][0] = grid[i][0];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (grid[i][j] != 0) {
                    int smaller = counts[i - 1][j];
                    if (counts[i][j - 1] < smaller) {
                        smaller = counts[i][j - 1];
                    }
                    if (counts[i - 1][j - 1] < smaller) {
                        smaller = counts[i - 1][j - 1];
                    }
                    counts[i][j] = smaller + 1;
                } else {
                    counts[i][j] = grid[i][j];
                }
            }
        }
        long count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                count += counts[i][j];
            }
        }
        return count;
    }
}
