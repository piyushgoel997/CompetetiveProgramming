import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 6/9/2017.
 * Code Jam Round 1A 2017 A.
 */
public class Ratatouille {

    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int ans = solve();
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static int solve() {
        // input taking
        int n = s.nextInt();
        int p = s.nextInt();
        int[] wts = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = s.nextInt();
        }
        double[][] qty = new double[n][p];
        double[][] min = new double[n][p];
        double[][] max = new double[n][p];
        boolean[][] used = new boolean[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                int temp = s.nextInt();
                qty[i][j] = temp / (1.0 * wts[i]);
                used[i][j] = false;
            }
            Arrays.sort(qty[i]); // sort each ingredient by quantities
        }


        // fill in min and max possible quantities without wastage.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                min[i][j] = qty[i][j] / 1.1;
                max[i][j] = qty[i][j] / 0.9;
            }
        }

        int kits = 0;
        // do the main work.
        for (int k = 0; k < p; k++) {
            int currMin = leastInteger(min[0][k]);
            int currMax = (int) max[0][k];
            if (currMax < currMin) {
                continue;
            }
            boolean canBeMade = true;
            ArrayList<Integer> saved = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                int j;
                for (j = 0; j < p; j++) {
                    if (!used[i][j]) {
                        if ((max[i][j] >= currMin && min[i][j] <= currMin) || (min[i][j] <= currMax && max[i][j] >= currMin)) {
                            saved.add(j);
                            currMin = Math.max(currMin, leastInteger(min[i][j]));
                            currMax = Math.min(currMax, (int) max[i][j]);
                            break;
                        }
                    }
                }
                if(j == p) {
                    canBeMade = false;
                    break;
                }
            }
            used[0][k] = true;
            if (canBeMade) {
                kits++;
                for (int i = 1; i < n; i++) {
                    used[i][saved.get(i - 1)] = true;
                }
            }
        }
        return kits;
    }

    private static int leastInteger(double v) {
        double V = ((int) v)*1.0;
        if (v - V == 0) {
            return (int) v;
        } else {
            return (int) (v + 1);
        }
    }
}