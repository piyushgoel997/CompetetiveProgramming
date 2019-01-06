import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CoffeeBreaks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        long[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(a);

        HashMap<Long, Integer> ans = new HashMap<>();

        int i = 0;
        int j = 1;
        ans.put(a[0], 1);
        int maxDays = 1;
        while (j < n) {
            if (a[j] - a[i] > d) {
                ans.put(a[j], ans.get(a[i]));
                i++;
                j++;
            } else {
                ans.put(a[j], ++maxDays);
                j++;
            }
        }

        System.out.println(maxDays);
        for (int k = 0; k < n; k++) {
            System.out.print(ans.get(copy[k]));
            System.out.print(" ");
        }

    }

}



//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        long m = Long.parseLong(st.nextToken());
//        long d = Long.parseLong(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        long[] a = new long[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = Long.parseLong(st.nextToken());
//        }
//        long[] copy = Arrays.copyOf(a, a.length);
//        Arrays.sort(a);
//        HashMap<Integer, Long> map = new HashMap<>();
//        HashMap<Long, Integer> ans = new HashMap<>();
//        map.put(1, a[0]);
//        ans.put(a[0], 1);
//        for (int i = 1; i < n; i++) {
//            boolean found = false;
//            for (Integer x : map.keySet()) {
//                if (a[i] - map.get(x) > d) {
//                    ans.put(a[i], x);
//                    map.put(x, a[i]);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                map.put(map.size() + 1, a[i]);
//                ans.put(a[i], map.size());
//            }
//        }
//        System.out.println(map.size());
//        for (int i = 0; i < n; i++) {
//            System.out.print(ans.get(copy[i]));
//            System.out.print(" ");
//        }
//    }
