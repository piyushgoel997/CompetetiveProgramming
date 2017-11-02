package DataStructures.Arrays;

import java.util.Scanner;

/**
 * Created by piyus on 14-10-2017 at 17:33.
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            int k = s.nextInt();
            System.out.println(binarySearch(arr, k));
        }
    }

    private static int binarySearch(int[] arr, int k) {
        int r = rotatedBy(arr);
        int i = 0;
        int j = arr.length;
        while (i < j) {
            int idx =  ((i + (j - i) / 2) + r) % arr.length;
            if (arr[idx] == k) return idx;
            else if (arr[idx] < k) i = i + 1 + (j - i) / 2;
            else j = i + (j - i) / 2;
        }
        return -1;
    }

    private static int rotatedBy(int[] arr) {
        int i = 0;
        int j = arr.length;
        if (arr[i] < arr[j - 1]) return 0;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > arr[mid + 1]) return mid + 1;
            else if (arr[mid] < arr[i]) j = mid;
            else i = mid + 1;
        }
        return 0;
    }
}
