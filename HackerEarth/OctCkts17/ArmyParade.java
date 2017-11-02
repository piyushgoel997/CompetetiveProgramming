package OctCkts17;

import java.util.Scanner;

/**
 * Created by piyus on 28-10-2017 at 23:58.
 */
public class ArmyParade {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        int[][] army = new int[n][m];
        for (int i = 0; i < k; i++) {
            army[s.nextInt()][s.nextInt()] = 1;
        }
    }
}
