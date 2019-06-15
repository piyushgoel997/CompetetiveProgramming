import java.util.Scanner;

public class A542 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextDouble();
        }
        for (double i = -1000; i <= 1000; i++) {
            if (i == 0) continue;
            int ct = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] / i > 0.0) {
                    ct++;
                }
            }
            if (ct >= (n + 1) / 2) {
                System.out.println((int)i);
                return;
            }
        }
        System.out.println(0);
    }
}
