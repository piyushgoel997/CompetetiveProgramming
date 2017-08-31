package Misc;

import java.util.Scanner;

/**
 * Created by piyus on 30-08-2017 at 16:44.
 * HackerRank. Misc - Hard. Correct
 */
public class MatrixLayerRotation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int r = s.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) matrix[i][j] = s.nextInt();
        for (int i = 0; i < Math.min(m, n); i++) rotate(matrix, i, n - 1 - i, i, m - 1 - i, r);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix, final int row1, final int row2, final int col1, final int col2, int r) {
        if (row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0 || row1 > row2 || col1 > col2) return;
        if (row1 == row2 || col1 == col2) {
            //TODO
        }
        int numOfElements = 2 * (row2 - row1 + col2 - col1);
        r = r % numOfElements;
        int[] arr = new int[numOfElements];
        int k = numOfElements - r;
        // writing to array
        for (int i = col1; i < col2; i++) {
            if (k >= numOfElements) k = 0;
            arr[k++] = matrix[row1][i];
        }

        for (int i = row1; i < row2; i++) {
            if (k >= numOfElements) k = 0;
            arr[k++] = matrix[i][col2];
        }
        for (int i = col2; i > col1; i--) {
            if (k >= numOfElements) k = 0;
            arr[k++] = matrix[row2][i];
        }
        for (int i = row2; i > row1; i--) {
            if (k >= numOfElements) k = 0;
            arr[k++] = matrix[i][col1];
        }

        // writing to the matrix
        k = 0;
        for (int i = col1; i < col2; i++) matrix[row1][i] = arr[k++];
        for (int i = row1; i < row2; i++) matrix[i][col2] = arr[k++];
        for (int i = col2; i > col1; i--) matrix[row2][i] = arr[k++];
        for (int i = row2; i > row1; i--) matrix[i][col1] = arr[k++];
    }

}
