import java.util.Scanner;

public class CommentaryBoxex {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long m = s.nextLong();
        int a = s.nextInt();
        int b = s.nextInt();

        long x = (b * (n % m));
        long y = (a * (m - (n % m)));
        System.out.println(Math.min(x, y));
    }
}
