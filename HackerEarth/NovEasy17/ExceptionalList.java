package NovEasy17;

import java.util.*;

/**
 * Created by piyus on 01-11-2017 at 22:38.
 */
public class ExceptionalList {
    private static long[][] table;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        table = new long[n+1][n+1];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            int l = s.nextInt();
            int r = s.nextInt();
            if (l > i + 1 || r < l || l < 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(exceptional(arr, l, Math.min(i + 1, r), i + 1));
        }
    }

    private static long exceptional(int[] arr, int l, int r, int n) {
        if (table[l][r] > 0) return table[l][r];
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> lengths = new ArrayList<>();
        List<Integer> overlap = new ArrayList<>();
        while (j < n) {
            if (set.contains(arr[j])) {
                if (j - i > 0) lengths.add(j - i);
//                System.out.print(i + "," + j+ "|");
                while (arr[i] != arr[j]) {
                    set.remove(arr[i]);
                    i++;
                }
                set.remove(arr[i]);
                i++;
                if (j - i > 0) overlap.add(j - i);
            }
            set.add(arr[j]);
            j++;
        }
        lengths.add(j - i);
//        System.out.print(i + "," + j+ "|");
        long ans = 0;
        for (int len : lengths) {
//            System.out.print(len + "|");
            if (len < l) continue;
            long a = len - l + 1;
            long b = 0;
            if (r < len) {
                b = len - r;
            }
            a = a * (a + 1) / 2;
            b = b * (b + 1) / 2;
            ans += a - b;
//            System.out.print(a - b);
//            System.out.print(" ");
        }
        for (int len : overlap) {
//            System.out.print(len + "|");
            if (len < l) continue;
            long a = len - l + 1;
            long b = 0;
            if (r < len) {
                b = len - r - 1;
            }
            a = a * (a + 1) / 2;

            b = b * (b + 1) / 2;
            ans -= a - b;
//            System.out.print("ol" + (a - b));
//            System.out.print(" ");
        }
        return table[l][r] = ans;
    }


        private static long numOfExceptional(int[] arr, int l, int r) {
        Set<Integer> set = new HashSet<>();
        List<Integer> lengths = new ArrayList<>();
        int len = 0;
        for (int i = l; i <= r; i++) {
            if (set.contains(arr[i])) {
                set = new HashSet<>();
                lengths.add(len);
                len = 1;
            } else {
                set.add(arr[i]);
                len++;
            }
        }
        lengths.add(len);
        long ans = 0;
        for (int i : lengths) {

        }
        return ans;
    }

    public static long factorial(long n) {
        long fact = 1;
        for (long i = 2; i <= n; i++) fact = (fact * i);
        return fact;
    }
}
