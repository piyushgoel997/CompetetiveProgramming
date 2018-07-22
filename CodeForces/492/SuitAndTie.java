import java.util.HashMap;
import java.util.Scanner;

public class SuitAndTie {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) arr[i] = s.nextInt();
        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            HashMap<Integer, Integer> found = new HashMap<>();
            for (int j = 0; j < 2 * n; j++) {
                if (found.containsKey(arr[j]) && found.get(arr[j]) != j - 1) {
                    count += swaps(arr, found.get(arr[j]) + 1, j);
                    break;
                }
                found.put(arr[j], j);
            }
        }
        System.out.println(count);
    }

    private static int swaps(int[] arr, int i, int j) {
        int temp = arr[j];
        for (int k = i; k <= j; k++) {
            int x = arr[k];
            arr[k] = temp;
            temp = x;
        }
        return j - i;
    }
}
