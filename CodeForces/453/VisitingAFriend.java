import java.util.Scanner;

/**
 * Created by piyus on 19-12-2017 at 21:06.
 */
public class VisitingAFriend {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            b[i] = s.nextInt();
        }

        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (curr >= m) {
                System.out.println("YES");
                return;
            }
            if (a[i] <= curr) {
                curr = Math.max(curr, b[i]);
            } else {
                break;
            }
        }
        if (curr >= m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


//        if (a[0] > 0) {
//            System.out.println("NO");
//            return;
//        }
//        for (int i = 1; i < n; i++) {
//            if (a[i] > b[i - 1]) {
//                if (b[i - 1] >= m) {
//                    System.out.println("YES");
//                } else {
//                    System.out.println("NO");
//                }
//                return;
//            }
//        }
//        if (b[n - 1] >= m) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
    }
}
