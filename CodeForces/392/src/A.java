import java.util.Scanner;

/**
 * Created by Piyush on 19-01-2017.
 */
public class A {
    public static void main(String[] z) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += max - arr[i];
        }
        System.out.println(sum);

    }

}
