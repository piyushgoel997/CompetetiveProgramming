import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by piyus on 02-12-2017 at 21:02.
 */
public class ItheaPlaysWithChtholly {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int c = s.nextInt();
        int[] sheets = new int[n];
        for (int i = 0; i < m; i++) {
            int p = s.nextInt();
//            System.out.println(write(sheets, p));
            System.out.flush();
            if (won(sheets)) return;
        }
    }

    private static boolean won(int[] sheets) {
        for (int i = 0; i < sheets.length - 1; i++) {
            if (sheets[i] > sheets[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
