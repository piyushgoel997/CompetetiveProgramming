package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 04-09-2017 at 17:28.
 * HackerRank. Greedy - Medium. Correct.
 */
public class MinMax {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        int[] list = new int[N];

        for(int i = 0; i < N; i ++)
            list[i] = Integer.parseInt(in.readLine());

        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(list);
        K--;
        for (int i = 0; i + K < N; i++) {
            if (list[i + K] - list[i] < unfairness) unfairness = list[i + K] - list[i];
        }

        System.out.println(unfairness);
    }
}
