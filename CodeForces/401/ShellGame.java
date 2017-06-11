import java.util.Scanner;

/**
 * Created by piyus on 24-02-2017.
 */
public class ShellGame {

    public static void main(String[] z) {
        Scanner s = new Scanner(System.in);
        int[] shells = new int[3];
        for (int i = 0; i < 3; i++) {
            shells[i] = 0;
        }
        int n = s.nextInt();
        int x = s.nextInt();
        shells[x] = 1;

        for (int i = n; i > 0; i--) {
            if (i % 2 == 1) {
                shells[0] += shells[1];
                shells[1] = shells[0] - shells[1];
                shells[0] = shells[0] - shells[1];
            } else {
                shells[2] += shells[1];
                shells[1] = shells[2] - shells[1];
                shells[2] = shells[2] - shells[1];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (shells[i] == 1) {
                System.out.println(i);
            }
        }
    }

}
