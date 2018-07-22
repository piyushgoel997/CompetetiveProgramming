package SeptCkts17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by piyus on 30-09-2017 at 18:14.
 */
public class MathisonMedFacilities {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int m = s.nextInt();
        int[] profit = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                profit[j] += s.nextInt();
            }
        }
        for (int i = 0; i < n; i++) profit[i] -= s.nextInt();
        ArrayIndexComparator comparator = new ArrayIndexComparator(profit);
        Integer[] index = comparator.createIndexArray();
        Arrays.sort(index, comparator);
        for (int i = n - k; i < n; i++) System.out.print(index[i] + 1 + " ");
    }

    public static class ArrayIndexComparator implements Comparator<Integer> {

        private final int[] array;

        public ArrayIndexComparator(int[] array) {
            this.array = array;
        }

        public Integer[] createIndexArray() {
            Integer[] indexes = new Integer[array.length];
            for (int i = 0; i < array.length; i++) indexes[i] = i;
            return indexes;
        }

        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(array[i1], array[i2]);
        }
    }

}
