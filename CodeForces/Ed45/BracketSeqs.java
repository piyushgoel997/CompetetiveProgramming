import java.util.HashMap;
import java.util.Scanner;

public class BracketSeqs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] bs = new String[n];
        for (int i = 0; i < n; i++) {
            bs[i] = s.next();
        }
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = process(bs[i]);
            if (x == Integer.MAX_VALUE) continue;
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1L);
        }
        long count = 0;
        for (int x : map.keySet()) {
            if (x < 0) continue;
            if (x == 0) count += map.get(x) * map.get(x);
            else if (map.containsKey((-1) * x)) {
                count += map.get(x) * map.get((-1) * x);
            }
        }
        System.out.println(count);
    }

    private static int process(String b) {
        int open = 0;
        int close = 0;
        for (char c : b.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open == 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        if (open == 0 && close == 0) return 0;
        if (close == 0) return open;
        if (open == 0) return close * (-1);
        return Integer.MAX_VALUE;
    }

}
