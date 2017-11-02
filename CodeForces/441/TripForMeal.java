import java.util.Scanner;

/**
 * Created by piyus on 16-10-2017 at 16:44.
 */
public class TripForMeal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        boolean r = true;
        boolean o = false;
        int dist = 0;
        for (int i = 1; i < n; i++) {
            if (r) {
                if (a < b) {
                    r = false;
                    o = true;
                    dist += a;
                } else {
                    r = false;
                    o = false;
                    dist += b;
                }
            } else if (o) {
                if (a < c) {
                    r = true;
                    o = false;
                    dist += a;
                } else {
                    r = false;
                    o = false;
                    dist += c;
                }
            } else {
                if (b < c) {
                    o = false;
                    r = true;
                    dist += b;
                } else {
                    r = false;
                    o = true;
                    dist += c;
                }
            }
        }
        System.out.println(dist);
    }
}
