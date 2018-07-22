import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PolyPractice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int x = copy[n - 1 - i];
            sum += x;
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        System.out.println(sum);
        int p = 0;
        for (int i = 0; i < n; i++) {
            p++;
            if (map.containsKey(a[i])) {
                if (map.size() == 1 && map.get(a[i]) == 1) {
                    p += (n - i - 1);
                    System.out.print(p);
                    return;
                }else {
                    System.out.print(p);
                    System.out.print(" ");
                }
                p = 0;
                if (map.get(a[i]) == 1) {
                    map.remove(a[i]);
                } else {
                    map.put(a[i], map.get(a[i]) - 1);
                }
            }
        }
    }

}
