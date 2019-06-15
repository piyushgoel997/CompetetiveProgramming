import java.util.Scanner;

public class MinimumInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            long l = s.nextLong();
            long r = s.nextLong();
            long d = s.nextLong();
            if (l > d) {
                System.out.println(d);
                continue;
            }
            System.out.println(d * ((r / d) + 1));
        }

    }
}
