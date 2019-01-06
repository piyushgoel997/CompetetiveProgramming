import java.util.Scanner;

public class ChristmasOrnament {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int y = s.nextInt();
        int b = s.nextInt();
        int r = s.nextInt();
        int min = Integer.min(y, Math.min(b - 1, r - 2));
        System.out.println(3 * min + 3);
    }
}
