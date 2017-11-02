import java.util.Scanner;

/**
 * Created by piyus on 16-10-2017 at 17:22.
 * 876D
 */
public class SortingTheCoins {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[] xCoin = new boolean[n];
        System.out.print("1 ");
        int correctlyPlaced = 0;
        int i = n - 1;
        for (int c = 1; c <= n; c++) {
            int next = s.nextInt();
            xCoin[next - 1] = true;
            while (i >= 0 && xCoin[i]) {
                correctlyPlaced++;
                i--;
            }
            System.out.print((c - correctlyPlaced + 1) + " ");
        }
    }
}
