import java.util.*;

public class ReorderTheArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }

        int count = 0;
        int prev = 0;
        for (int i : map.keySet()) {
            int curr = map.get(i);
            if (prev >= curr) {
                count += curr;
            } else {
                count += prev;
                prev = curr;
            }
        }
        System.out.println(count);
    }
}
