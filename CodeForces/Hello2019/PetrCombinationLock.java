import java.util.Scanner;

public class PetrCombinationLock {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        if (fn(arr, 0, true, 0) || fn(arr, 0, false, 0)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean fn(long[] arr, int i, boolean plus, long curr) {
        if (i >= arr.length) {
            if (curr == 0 || curr % 360 == 0) return true;
            else return false;
        }
        if (plus) curr += arr[i];
        else curr -= arr[i];
        return fn(arr, i + 1, true, curr) || fn(arr, i + 1, false, curr);
    }
}
