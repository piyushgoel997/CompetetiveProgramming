import java.util.Scanner;

public class SquareDifference {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            long a = s.nextLong();
            long b = s.nextLong();
            if (a - b == 1) {
                boolean isPrime = true;
                for (int j = 2; j < Math.sqrt(a + b); j++) {
                    if ((a + b) % j == 0) {
                        System.out.println("NO");
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println("YES");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
