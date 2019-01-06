import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumValueRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> sides = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                sides.putIfAbsent(x, 0);
                sides.put(x, sides.get(x) + 1);
            }
            ArrayList<Integer> list = new ArrayList<>();
            boolean cont = false;
            for (Integer i : sides.keySet()) {
                if (sides.get(i) / 2 == 1) {
                    list.add(i);
                }
                if (sides.get(i) >= 4) {
                    System.out.println(i + " " + i + " " + i + " " + i);
                    cont = true;
                    break;
                }
            }
            if (cont) continue;
//            Collections.sort(list);
            int a = list.get(0);
            int b = list.get(1);
            for (int i = 0; i < list.size() - 1; i++) {
                int x = list.get(i);
//                int y = list.get(i + 1);
//                if (Math.abs(x - y) < Math.abs(a - b)) {
//                    a = x;
//                    b = y;
//                }
                for (int j = i + 1; j < list.size(); j++) {
                    int y = list.get(j);
                    if (((x * 1.0) / y) + ((y * 1.0) / x) < ((a * 1.0) / b) + ((b * 1.0) / a)) {
                        a = x;
                        b = y;
                    }
                }
            }
            System.out.println(a + " " + a + " " + b + " " + b);
        }
    }
}
