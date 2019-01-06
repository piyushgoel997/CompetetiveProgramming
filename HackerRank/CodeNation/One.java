import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        s.nextInt();
        double[][] disc = new double[n][k];
        for (int i = 0; i < k; i++) {
            s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                disc[i][j] = s.nextInt();
            }
        }

        double[][] mids = new double[k][2];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                mids[i][0] += disc[j][i];
            }
            mids[i][1] = Math.ceil(mids[i][1] / n);
            mids[i][0] = Math.floor(mids[i][0] / n);
        }

        double[][] rotations = new double[k][2];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                rotations[i][0] += Math.abs(mids[i][0] - disc[j][i]);
                rotations[i][1] += Math.abs(mids[i][1] - disc[j][i]);
            }
        }

        double min = Double.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, Math.min(rotations[i][0], rotations[i][1]));
        }

        System.out.println((long) min);

    }
}
