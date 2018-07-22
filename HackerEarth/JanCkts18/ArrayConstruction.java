package JanCkts18;

import java.util.Scanner;

/**
 * Created by piyus on 21-01-2018 at 13:28.
 */
public class ArrayConstruction {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        for (int i = 0; i < (n - (m % n)); i++) {
            System.out.print(m / n);
            System.out.print(" ");
        }
        for (int i = (n - (m % n)); i < n; i++) {
            System.out.print((m / n) + 1);
            System.out.print(" ");
        }
    }
}
