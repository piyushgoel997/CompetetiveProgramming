import java.util.Scanner;

public class AdjRep {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            long x = s.nextLong();
            if (x % 2 == 0) {
                System.out.print(x - 1);
            } else {
                System.out.print(x);
            }
            System.out.print(" ");
        }

    }
}
