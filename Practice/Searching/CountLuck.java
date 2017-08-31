package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 31-08-2017 at 15:14.
 */
public class CountLuck {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            char[][] grid = new char[n][m];
            for (int j = 0; j < n; j++) grid[j] = s.next().toCharArray();
            int iM = -1, jM = -1;
            for (int j = 0; j < n; j++) for (int k = 0; k < m; k++) if (grid[j][k] == 'M') { iM = j ; jM = k; }
            int a = findKey(grid, iM, jM, new int[]{0, 0});
//            System.out.println(a);
            if (a == s.nextInt()) System.out.println("Impressed");
            else System.out.println("Oops!");
        }
    }

    private static int findKey(char[][] grid, int iM, int jM, int[] prevDir) {
        if (grid[iM][jM] == '*') return 0;
        ArrayList<int[]> possibleDirs = possibleDirs(grid, iM, jM, prevDir);
        if (possibleDirs.size() == 0) return -1;
        grid[iM][jM] = 'M';
        int minChanges = 99999;
        for (int[] nextDir : possibleDirs) {
            int changes = findKey(grid, iM + nextDir[0], jM + nextDir[1], nextDir);
            if (changes == -1) continue;
            if (possibleDirs.size() > 1) changes++;
            if (changes < minChanges) minChanges = changes;
        }
        if (minChanges == 99999) return -1;
        return minChanges;
    }

    private static ArrayList<int[]> possibleDirs(char[][] grid, int iM, int jM, int[] prevDir) {
        int[][] arr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        ArrayList<int[]> dirs = new ArrayList<>();
        for (int[] a : arr) {
//            if (a[0] != -prevDir[0] || a[1] != -prevDir[1]) {
            int i = iM + a[0];
            int j = jM + a[1];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)
                if (grid[i][j] == '.' || grid[i][j] == '*') dirs.add(a);
//            }
        }
        return dirs;
    }

}

/*
1
        4 11
        *X.X......X
        .X..X.XXX.X
        .XX.X.XM...
        ......XXXX.
        4
*/