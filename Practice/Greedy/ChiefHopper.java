package Greedy;

import java.util.Scanner;

/**
 * Created by piyus on 07-09-2017 at 01:07.
 * HackerRank. Greedy - Hard. Correct.
 */
public class ChiefHopper {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        long currEnergy = 0;
        for (int i = n - 1; i >= 0; i--) {
            currEnergy = (currEnergy + a[i] + 1) / 2;
        }
        System.out.println(currEnergy);
    }
}
