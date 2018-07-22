package Misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by piyus on 20-10-2017 at 17:05.
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 */
public class MedianInAStream {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (left.isEmpty() || x > left.peek()) {
                right.add(x);
            } else {
                left.add(x);
            }
            while (left.size() - right.size() > 1) {
                right.add(left.remove());
            }
            while (right.size() - left.size() > 1) {
                left.add(right.remove());
            }
            if (left.size() > right.size()) {
                System.out.println(left.peek());
            } else if (left.size() < right.size()) {
                System.out.println(right.peek());
            } else {
                System.out.println((left.peek() + right.peek()) / 2);
            }
        }
    }
}
