import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LuckyDip {
//    public static void main(String[] args) throws FileNotFoundException {
////        Scanner s = new Scanner(new File("C:\\My Folder\\Programming\\CompetetiveProgramming\\CodeJam2017\\src\\in"));
//        Scanner s = new Scanner(System.in);
//        int T = s.nextInt();
//        for (int t = 0; t < T; t++) {
//            int n = s.nextInt();
//            int k = s.nextInt() + 1;
//            double[] values = new double[n];
//            double avg = 0;
//            boolean allEqual = true;
//            for (int i = 0; i < n; i++) {
//                values[i] = s.nextLong();
//                if (allEqual && i > 0) if (values[i] != values[i - 1]) allEqual = false;
//                avg += values[i];
//            }
//            if (allEqual) {
//                System.out.printf("Case #" + (t + 1) + ": %.6f", values[0]);
//                System.out.println();
//                continue;
//            }
//            avg = avg / n;
//            double occurrences = 0;
//            for (double value : values) if (value > avg) occurrences++;
//            double x = (1.0 * (n - occurrences)) / n;
//            double prob = (1.0 / n) * (1 - Math.pow(x, k)) / (1 - x);
//            double otherProb = (1 - occurrences*prob) / (n- occurrences);
//            double ans = 0;
//            for (double value : values) {
//                if (value > avg) ans += value * prob;
//                else ans += (value * otherProb);
//            }
//            System.out.printf("Case #" + (t + 1) + ": %.6f", ans);
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\My Folder\\Programming\\CompetetiveProgramming\\CodeJam2017\\src\\in"));
//        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int K = s.nextInt();
            double[] values = new double[n];
            double avg = 0;
            boolean allEqual = true;
            double[] suffixSum = new double[n];
            for (int i = 0; i < n; i++) {
                values[i] = s.nextLong();
                if (allEqual && i > 0) if (values[i] != values[i - 1]) allEqual = false;
                avg += values[i];
            }
            Arrays.sort(values);
            for (int i = n - 1; i >= 0; i--) {
                suffixSum[i] = values[i];
                if (i < n - 1) suffixSum[i] += suffixSum[i + 1];
            }
            if (allEqual) {
                System.out.printf("Case #" + (t + 1) + ": %.6f", values[0]);
                System.out.println();
                continue;
            }

            avg = avg / n;
            double expectedValue = avg;

            for (int k = 0; k < K; k++) {
                int idx = Arrays.binarySearch(values, expectedValue);
                if (idx < 0) idx = -idx - 1;
                double greater = suffixSum[idx] / n;
                double lower = idx * expectedValue / n;
                expectedValue = greater + lower;
            }
            System.out.printf("Case #" + (t + 1) + ": %.6f", expectedValue);
            System.out.println();
        }
    }




}
