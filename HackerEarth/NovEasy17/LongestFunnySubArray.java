package NovEasy17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 01-11-2017 at 22:01.
 */
public class LongestFunnySubArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Integer, Integer> index = new HashMap<>();
        int maxFunny = 0;
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (index.containsKey(x)) {
                int funny = i - index.get(x) + 1;
                maxFunny = Math.max(maxFunny, funny);
            } else {
                index.put(x, i);
            }
        }
        System.out.println(maxFunny);
    }
}
