package DecEasy17;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.*;

/**
 * Created by piyus on 01-12-2017 at 22:22.
 */
public class SupremeSubset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long m = s.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = s.nextLong();
        Arrays.sort(a);

//        HashMap<Long, StringBuilder> map = new HashMap<>();
//
//        for (int i = a.length - 1; i >= 0; i--) {
//            long q = (a[i] + m) % m;
//            if (map.containsKey(q)) {
//                map.put(q, map.get(q).append(" ").append(a[i]));
//            } else {
//                map.put(q, new StringBuilder(Long.toString(a[i])));
//            }
//        }
//
//        String largest = "";
//        int maxSize = 0;
//        for (long q : map.keySet()) {
//            String str = new String(map.get(q));
//            if (str.length() > maxSize) {
//                largest = str;
//                maxSize = str.length();
//            } else if (str.length() == maxSize) {
//                if (str.compareTo(largest) < 0) {
//                    largest = str;
//                }
//            }
//        }
//
//        System.out.println(largest.length() / 2 + 1);
//        for (int i = largest.length() - 1; i >= 0; i--) {
//            System.out.print(largest.charAt(i));
//        }


















        HashMap<Long, Integer> qtnt = new HashMap<>();
        HashMap<Long, Long> max = new HashMap<>();
        int maxSize = 0;

        for (long anA : a) {
            long q = (anA + m) % m;

            if (qtnt.containsKey(q)) {
                qtnt.put(q, qtnt.get(q) + 1);
                if (anA > max.get(q)) max.put(q, anA);
            } else {
                qtnt.put(q, 1);
                max.put(q, anA);
            }

            if (qtnt.get(q) > maxSize) {
                maxSize = qtnt.get(q);
            }
        }

        long maxQ = 0;
        long currMin = Long.MAX_VALUE;
        for (Long l : qtnt.keySet()) {
            if (qtnt.get(l) == maxSize && lexoCompare(max.get(l), currMin)) {
                currMin = max.get(l);
                maxQ = l;
            }
        }


        System.out.println(maxSize);
        for (long anA : a) {
            if ((m + anA) % m == maxQ) {
                System.out.print(anA + " ");
            }
        }
    }

    private static boolean lexoCompare(long a, long b) {
        // true if a is smaller
        String as = Long.toString(a);
        String bs = Long.toString(b);
        int i = 0;
        while (i < as.length() && i < bs.length()) {
            if (as.charAt(i) < bs.charAt(i)) {
                return true;
            }
            i++;
        }
        if (i == bs.length()) {
            return false;
        }
        if (i == as.length()) {
            return true;
        }
        return false;
    }
}
