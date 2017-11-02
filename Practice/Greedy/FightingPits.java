package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by piyus on 14-09-2017 at 22:36.
 * HackerRank. Greedy - Hard. Correct.
 */
public class FightingPits {

    // its ur turn and total str of ur team is >= total str of opp team
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int q = s.nextInt();
        ArrayList<Integer>[] teams = new ArrayList[k];
        ArrayList<Integer>[] csum = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            teams[i] = new ArrayList<>();
            csum[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int strength = s.nextInt();
            teams[s.nextInt() - 1].add(strength);
        }
        for (int i = 0; i < k; i++) Collections.sort(teams[i]);

        for (int i = 0; i < k; i++) {
            if (teams[i].size() > 0) {
                csum[i].add(teams[i].get(0));
                for (int j = 1; j < teams[i].size(); j++) {
                    csum[i].add(teams[i].get(j) + csum[i].get(j - 1));
                }
            }
        }
        for (int i = 0; i < q; i++) {
            if (s.nextInt() == 1) {
                int strength = s.nextInt();
                int t = s.nextInt() - 1;
                teams[t].add(strength);
                if (csum[t].size() >= 1) csum[t].add(strength + csum[t].get(csum[t].size() - 1));
                else csum[t].add(strength);
            } else {
                System.out.println(whoWins(teams, csum, s.nextInt() - 1, s.nextInt() - 1) + 1);
            }
        }
    }

    private static int whoWins(ArrayList<Integer>[] teams, ArrayList<Integer>[] csum, int x, int y) {
        int i = teams[x].size() - 1;
        int j = teams[y].size() - 1;
        while (true) {
            if (i < 0) return y;
            if (csum[x].get(i) >= csum[y].get(j)) return x;
            j -= teams[x].get(i);

            if (j < 0) return x;
            if (csum[x].get(i) <= csum[y].get(j)) return y;
            i -= teams[y].get(j);
        }
    }


//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int k = s.nextInt();
//        int q = s.nextInt();
//        ArrayList<Integer>[] teams = new ArrayList[k];
//        for (int i = 0; i < k; i++) teams[i] = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int strength = s.nextInt();
//            teams[s.nextInt() - 1].add(strength);
//        }
//        for (int i = 0; i < k; i++) Collections.sort(teams[i]);
//        for (int i = 0; i < q; i++) {
//            if (s.nextInt() == 1) {
//                int strength = s.nextInt();
//                teams[s.nextInt() - 1].add(strength);
//            } else {
//                System.out.println(whoWins(teams, s.nextInt() - 1, s.nextInt() - 1) + 1);
//            }
//        }
//    }
//
//    private static int whoWins(ArrayList<Integer>[] teams, int x, int y) {
//        int i = teams[x].size() - 1;
//        int j = teams[y].size() - 1;
//        while (true) {
//            if (i < 0) return y;
//            j -= teams[x].get(i);
//            if (j < 0) return x;
//            i -= teams[y].get(j);
//        }
//    }

}
