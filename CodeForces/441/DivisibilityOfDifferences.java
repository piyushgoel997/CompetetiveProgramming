import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 16-10-2017 at 16:59.
 */
public class DivisibilityOfDifferences {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int m = s.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            int x = arr[i] % m;
            if (hm.containsKey(x)) {
                hm.put(x, hm.get(x) + 1);
            } else {
                hm.put(x, 1);
            }
        }
        int set = -1;
        for (int i : hm.keySet()) {
            if (hm.get(i) >= k) set = i;
        }
        if (set == -1) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
        int k1 = 0;
        for (int i = 0; i < n; i++) {
            if (k1 >= k) {
                break;
            }
            if (arr[i] % m == set) {
                k1++;
                System.out.print(arr[i] + " ");
            }
        }
    }
}
