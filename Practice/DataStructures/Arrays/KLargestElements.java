package DataStructures.Arrays;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by piyus on 15-10-2017 at 15:37.
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * keep a Min PQ of size k.
 */
public class KLargestElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            int[] kMax = kLargest(arr, k);
            for (int i = 0; i < k; i++) {
                System.out.print(kMax[i] + " ");
            }
            System.out.println();
        }
    }

    private static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i : arr) {
            pq.add(i);
            while (pq.size() > k) pq.poll();
        }
        int[] kMax = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            kMax[i] = pq.poll();
        }
        return kMax;
    }
}
