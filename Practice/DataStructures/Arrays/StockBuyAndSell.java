package DataStructures.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 18-10-2017 at 22:11.
 * http://www.geeksforgeeks.org/stock-buy-sell/
 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            ArrayList[] days = maxProfitDays(arr);
            if (days[0].size() == 0) {
                System.out.println("No Profit");
                continue;
            }
            for (int i = 0; i < days[0].size(); i++) {
                System.out.format("(%d %d) ", days[0].get(i), days[1].get(i));
            }
            System.out.println();
        }
    }

    private static ArrayList[] maxProfitDays(int[] arr) {
        ArrayList<Integer>[] days = new ArrayList[2];
        days[0] = new ArrayList<Integer>();
        days[1] = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (i < arr.length - 1 && arr[i + 1] <= arr[i]) {
                i++;
            }
            int minI = i;
            i++;
            while (i < arr.length - 1 && arr[i + 1] >= arr[i]) {
                i++;
            }
            int maxI = i;
            if (i < arr.length && arr[minI] < arr[maxI]) {
                days[0].add(minI);
                days[1].add(maxI);
            }
        }
        return days;
    }
}
