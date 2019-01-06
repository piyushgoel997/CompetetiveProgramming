import java.util.Scanner;

public class Fly {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        for (int i = 0; i < n; i++) b[i] = s.nextInt();
        double fuel = (1.0 * m) / (b[0] - 1);
        for (int i = n - 1; i > 0; i--) {
            fuel += (fuel + m) / (a[i] - 1);
            fuel += (fuel + m) / (b[i] - 1);
            if (Double.isInfinite(fuel)) {
                System.out.println(-1);
                return;
            }
        }
        fuel += (fuel + m) / (a[0] - 1);
        if (Double.isInfinite(fuel)) {
            System.out.println(-1);
            return;
        }
        System.out.println(fuel);
    }


}
