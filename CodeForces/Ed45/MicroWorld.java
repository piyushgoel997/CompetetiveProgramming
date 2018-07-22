import java.util.Arrays;
import java.util.Scanner;

public class MicroWorld {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);
        int ct = n;

        int i = 0;
        int j = 1;
        while (j < n) {
            if (a[i] == a[j]) {
                j++;
            } else {
                if (a[j] <= a[i] + k) {
                    ct -= (j - i);
                }
                i = j;
            }
        }

//        for (int i = 0; i < n - 1; i++) {
//            int j = i+1;
//            while (j < n && a[j] == a[i]) {
//                j++;
//            }
//            if (j >= n) {
//                break;
//            }
//            if (a[j] <= a[i] + k) {
//                ct -= j - i;
//                i = j - 1;
//            }
//        }
        System.out.println(ct);
    }

}
