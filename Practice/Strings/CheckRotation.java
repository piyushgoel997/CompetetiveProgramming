package Strings;

import java.util.Scanner;

/**
 * Created by piyus on 13-09-2017 at 16:47.
 * Check if a String is the rotation of the other.
 */
public class CheckRotation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            char[] one = s.next().toCharArray();
            char[] two = s.next().toCharArray();
            System.out.println(check2(one, two, one.length));
        }
    }

    // Time - O(n^2), Extra Space - O(1)
    private static boolean check1(char[] one, char[] two, int n) {
        if (n <= 0) return false;
        for (int start = 0; start < n; start++) {
            //checker loop
            int i = start, k = 0;
            for (k = 0; k < n; k++) {
                if (i == n) i = 0;
                if (one[k] != two[i]) break;
                i++;
            }
            if (k == n) return true;
        }
        return false;
    }

    // Time - time for string searching, Extra Space ~ 2*n + space for searching, if any.
    // join str = two + two -> if this contains IfAtFirst then return true else false.
    private static boolean check2(char[] one, char[] two, int n) {
        if (n <= 0) return false;
        char[] joined = new char[2 * n];
        for (int j = 0; j < 2; j++) System.arraycopy(two, 0, joined, j * n, n);
        return search(one, joined) != -1;
    }

    private static int search(char[] one, char[] joined) {
        return new String(joined).indexOf(new String(one));
    }
}
/*
10
abcdef abcdef
true
aaaa aaaa
true
abcdef fabcde
true
aklgjrs akersjbgk
false
asdfg asdfe
false
aaaaaaaaaaaaab
aaaaaaaabaaaaa
true
 */