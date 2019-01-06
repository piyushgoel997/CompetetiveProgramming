import java.util.Scanner;

public class PolygonForTheAngle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            double a = s.nextDouble();
            for (int i = 3; i <= 998244353; i++) {
                if (a % ((180 * 1.0) / i) == 0 && a <= ((1.0*i - 2) / i) * 180) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
