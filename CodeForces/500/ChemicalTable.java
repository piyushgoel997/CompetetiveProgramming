import java.util.Scanner;

public class ChemicalTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int q = s.nextInt();
        boolean[][] table = new boolean[n][m];
        for (int i = 0; i < q; i++) table[s.nextInt() - 1][s.nextInt() - 1] = true;

    }
}
