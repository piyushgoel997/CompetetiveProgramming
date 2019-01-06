import java.util.Scanner;

public class FindDivisible {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            long l = s.nextLong();
            long r = s.nextLong();
            System.out.print(l + " " + (2 * l));
            System.out.println();
        }
    }
}
