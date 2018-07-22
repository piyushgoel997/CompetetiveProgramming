package BitManipulation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 21-08-2017 at 23:13.
 * HackerRank. BitManipulation - Medium. Had to look at the solution for O(1) solution.
 * TODO - get back to this problem later. difficulty faced - too many corner cases.
 * also check the editorial.
 */
public class WhatsNext {

    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            solve1(n);
        }
    }


    //Completely incorrect solution. e.g. check for "110"
    private static void solve(int n) {
        long[] a = new long[10];
        for (int i = 10 - n; i < 10; i++) a[i] = s.nextLong();
        long[] c = new long[a.length + 2];
        for (int i = 0; i < a.length; i++) c[i] = a[i];
        if (n % 2 == 1) {
            c[8] = a[8] - 1;
            c[9] = 1;
            c[10] = 1;
            c[11] = a[9] - 1;
        } else {
            c[7] = a[7] - 1;
            c[8] = 1;
            c[9] = 1;
            c[10] = a[8] - 1;
            c[11] = a[9];
        }
        ArrayList<Long> al = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] < 0) continue;
            if (i > 1 && al.size() > 0 && c[i - 1] == 0) al.set(al.size() - 1, al.get(al.size() - 1) + c[i]);
            else if (c[i] > 0) al.add(c[i]);
        }
        System.out.println(al.size());
        for (Long anAl : al) {
            System.out.print(anAl + " ");
        }
        System.out.println();
    }

    private static void solve1(int n) {
        long[] a = new long[n + 1];
        for (int i = 1; i < n + 1; i++) a[i] = s.nextLong();
        ArrayList<Long> d = new ArrayList<>();
        if (n % 2 == 0) {
            int i;
            for (i = 0; i < a.length - 3; i++) d.add(a[i]);
            if (a[i] <= 1) {
                d.set(i - 1, d.get(i) + 1);
            } else {
                d.add(a[i] - 1);
                d.add((long) 1);
            }
            d.add(a[a.length - 1] + 1);
            d.add(a[a.length - 2] - 1);
        } else {
            int i;
            for (i = 0; i < a.length - 2; i++) d.add(a[i]);
            if (a[i] <= 1) {
                d.set(i - 1, d.get(i) + 1);
            } else {
                d.add(a[i] - 1);
                d.add((long) 1);
            }
            d.add((long) 1);
            d.add(a[a.length - 1] - 1);
        }
        int size = 0;
        for (Long aD : d) if (aD > 0) size++;
        System.out.println(size);
        for (Long aD : d) if (aD > 0) System.out.print(aD + " ");
        System.out.println();
    }
}
