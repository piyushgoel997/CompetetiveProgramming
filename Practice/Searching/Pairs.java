package Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 30-08-2017 at 18:13.
 * HackerRank. Searching - Medium. Correct.
 */
public class Pairs {

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int k = s.nextInt();
//        DivSet[] ds = new DivSet[n];
//        for (int i = 0; i < n; i++) {
//            int c = s.nextInt();
//            ds[i].qtnt = c / k;
//            ds[i].rem = c % k;
//        }
//        Arrays.sort(ds, new RComp().thenComparing(new QComp()));
//        int prevR = ds[0].rem;
//        int prevQ = ds[1].qtnt;
//        for (int i = 1; i < n; i++) {
//            while (i < n && )
//        }
//    }
//
//    public static class RComp implements Comparator<DivSet> {
//        @Override
//        public int compare(DivSet o1, DivSet o2) {
//            return Integer.compare(o1.rem, o2.rem);
//        }
//    }
//
//    public static class QComp implements Comparator<DivSet> {
//        @Override
//        public int compare(DivSet o1, DivSet o2) {
//            return Integer.compare(o1.qtnt, o2.qtnt);
//        }
//    }
//
//    public class DivSet{
//        int qtnt = 0;
//        int rem = 0;
//    }

    public static void main(String[] args) {
        // Two pointer Approach - Ingenious
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long k = s.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = s.nextLong();
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        long pairs = 0;
        while (j < n) {
            long diff = arr[j] - arr[i];
            if (diff < k) j++;
            else if (diff > k) i++;
            else {
                j++;
                pairs++;
            }
        }
        System.out.println(pairs);
    }
}
