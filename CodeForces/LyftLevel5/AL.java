import java.util.Scanner;

public class AL {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ax = s.nextInt();
        int ay = s.nextInt();
        int bx = s.nextInt();
        int by = s.nextInt();
        int cx = s.nextInt();
        int cy = s.nextInt();
        boolean possible = true;
        if (bx < ax && cx > ax) {
            possible = false;
        }
        if (bx > ax && cx < ax) {
            possible = false;
        }
        if (by < ay && cy > ay) {
            possible = false;
        }
        if (by > ay && cx < ay) {
            possible = false;
        }
        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
