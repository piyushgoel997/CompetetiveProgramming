package Jan18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 07-01-2018 at 19:55.
 */
public class Rectangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) arr[i] = s.nextInt();
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[2] == arr[3]) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
