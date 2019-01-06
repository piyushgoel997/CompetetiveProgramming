import java.util.Scanner;

public class PtsInSeg {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        boolean[] arr = new boolean[m];
        for (int i = 0; i < n; i++) {
            int l = s.nextInt() - 1;
            int r = s.nextInt() - 1;
            for (int j = l; j <= r; j++) {
                arr[j] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!arr[i]) count++;
        }
        System.out.println(count);
        for (int i = 0; i < m; i++) {
            if (!arr[i]) {
                System.out.print(i + 1);
                System.out.print(" ");
            }
        }
    }
}
