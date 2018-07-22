import java.util.Scanner;

/**
 * Created by Piyush on 21-10-2016.
 */

// Code Jam 2010, Round 1C
public class RopeIntranet {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = s.nextInt();
                b[j] = s.nextInt();
            }
            System.out.println("Case #"+(i+1)+": "+calculateIntersections(a,b));
        }

    }

    public static int calculateIntersections(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    if (b[j] < b[i]) {
                        count++;
                    }
                } else if (a[j] < a[i]) {
                    if (b[j] > b[i]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
