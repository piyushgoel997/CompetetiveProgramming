import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Piyush on 15-01-2017.
 */
public class EnemyBall {

    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int m = r.nextInt();
        if (n > m) {
            System.out.println("YES");
            return;
        }
        if (n < m) {
            System.out.println("NO");
            return;
        }
        String[] a = new String[n];
        String[] b = new String[m];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextLine();
        }
        for (int i = 0; i < m; i++) {
            b[i] = r.nextLine();
        }
        if (playGame(n,m,a,b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean playGame(int n, int m, String[] a, String[] b) {
        int i = 0;
        int j = 0;
        boolean isA = true;
        while (i < n && j < m) {
            if (a[i].length()==b[j].length()) {
                if (a[i].equals(b[j])) {
                    if (isA) return true;
                    else i++;
                }
            } else {
                i++;
                j++;
            }
        }
        if (i == n && j == m) {
            if (isA) return false;
            else return true;
        } else {
            if (i==n) return false;
            else return true;
        }
    }

}
