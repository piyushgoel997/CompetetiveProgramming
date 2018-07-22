package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 18-08-2017 at 14:44.
 * HackerRank. DP - Medium.
 */
public class Candies {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            candies[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1] && candies[i] >= candies[i - 1]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i];
        }
        System.out.println(total);
    }
}
