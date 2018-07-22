package Searching;

import java.util.Scanner;

/**
 * Created by piyus on 30-08-2017 at 19:16.
 */
public class ConnectedCellsInAGrid {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        boolean[][] grid = new boolean[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) grid[i][j] = s.nextInt() == 0;
        int max = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            if (!grid[i][j]) {
                int curr = dfs(grid, i, j);
                if (curr > max) max = curr;
            }
        }
        System.out.println(max);
    }

    private static int dfs(boolean[][] grid, int i, int j) {
        if (grid[i][j]) return 0;
        grid[i][j] = true;
        int dfs = 1;

        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (i + k < grid.length && j + l < grid[0].length && i + k >= 0 && j + l >= 0 && !grid[i+k][j+l]) dfs += dfs(grid, i + k, j + l);
            }
        }
        return dfs;
    }

}
