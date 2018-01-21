import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 28-12-2017 at 20:48.
 */
public class InversionCounting {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            swap(arr, scanner.nextInt() - 1, scanner.nextInt() - 1);
            int x = count(arr);
            System.out.println(x);
            if (x % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }

    private static int count(int[] arr) {
        int ct = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > i + 1) {
//                System.out.println(arr[i]+","+(i+1));
                ct += arr[i] - i - 1;
            }
        }
        return ct;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            swap(arr, scanner.nextInt() - 1, scanner.nextInt() - 1);
            int x = inversions(Arrays.copyOf(arr, n), 0, n - 1);
            System.out.println(x);
            if (x % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    private static int inversions(int[] arr, int i, int j) {
        if (j - i < 1) return 0;
        int mid = (i + j) / 2;
        int ct = inversions(arr, i, mid) + inversions(arr, mid + 1, j);
        ct += merge(arr, i, j);
        return ct;
    }

    private static int merge(int[] arr, int i, int j) {
        int mid = (i + j) / 2;
        int[] temp = new int[j - i + 1];
        int x = i;
        int y = mid + 1;
        int count = 0;
        while (x <= mid && y <= j) {
            if (arr[x] < arr[y]) {
                temp[x + y - i - mid - 1] = arr[x];
                x++;
            } else {
                temp[x + y - i - mid - 1] = arr[y];
                y++;
                count += mid + 1 - x;
            }
        }
        for (;x <= mid; x++) temp[x + y - i - mid - 1] = arr[x];
        for (;y <= j; y++) temp[x + y - i - mid - 1] = arr[y];
        for (int k = 0; k < temp.length; k++) {
            arr[i + k] = temp[k];
        }
        return count;
    }
*/

}
