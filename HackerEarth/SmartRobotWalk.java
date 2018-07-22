import java.util.Scanner;

/**
 * Created by piyus on 15-07-2017 at 15:53.
 * HP Think-a-thon. 1. Correct.
 */
public class SmartRobotWalk {
    // DLRU

    static int[] start = {0, 0};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] cities = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            cities[i][0] = s.nextInt();
            cities[i][1] = s.nextInt();
        }
        cities[n][0] = 0;
        cities[n][1] = 0;
        String str = "";
        for (int i = 0; i <= n; i++) {
            str += visitCity(cities[i]);
//            System.out.print(visitCity(cities[i]));
            start[0] = cities[i][0];
            start[1] = cities[i][1];
        }
        System.out.println(str.length());
        System.out.println(str);
    }

    private static String visitCity(int[] city) {
        String ans = "";
        int x = city[0] - start[0];
        int y = city[1] - start[1];
        if (y < 0) {
            y = -y;
            for (int i = 0; i < y; i++) {
                ans += "D";
            }
            y = 0;
        }
        if (x < 0) {
            x = -x;
            for (int i = 0; i < x; i++) {
                ans += "L";
            }
            x = 0;
        }
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                ans += "R";
            }
        }
        if (y > 0) {
            for (int i = 0; i < y; i++) {
                ans += "U";
            }
        }
        return ans;
    }
}
