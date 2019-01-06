import java.util.Scanner;

public class PilesWithStones {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long x = 0;
        long y = 0;
        for (int i = 0; i < n; i++) x += s.nextLong();
        for (int i = 0; i < n; i++) y += s.nextLong();
        if (y > x) System.out.println("No");
        else System.out.println("Yes");
    }
}
