import java.util.Arrays;
import java.util.Scanner;

public class ArrayStabalization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        if (arr.length == 2) {
            System.out.println(0);
            return;
        }
        System.out.println(Math.min(arr[n - 2] - arr[0], arr[n - 1] - arr[1]));
    }
}
