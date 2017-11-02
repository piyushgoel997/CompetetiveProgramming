import java.util.Scanner;

/**
 * Created by piyus on 26-10-2017 at 20:16.
 */
public class BoryaDiagnosis {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int days = 0;
//        int[] first = new int[n];
//        int[] gap = new int[n];
//        for (int i = 0; i < n; i++) {
//            first[i] = s.nextInt();
//            gap[i] = s.nextInt();
//        }
        for (int i = 0; i < n; i++) {
            int f = s.nextInt();
            if (days < f) {
                days = f;
            }
            int g = s.nextInt();
            while ((days - f) % g != 0) days++;
            days++;
        }
        System.out.println(--days);
    }
}
