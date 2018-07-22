import java.util.Scanner;

public class IfAtFirst {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int n = s.nextInt();
        int left = n - (a + b - c);
        if (left < 1 || (c > a + b) || c > b || c > a || a > n || b > n || c > n) {
            System.out.println(-1);
        } else {
            System.out.println(left);
        }
    }
}
