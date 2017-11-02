package Strings;

import java.util.Scanner;

/**
 * Created by piyus on 13-09-2017 at 00:30.
 * Return a reversed sentence in time O(n).
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseString((new Scanner(System.in)).nextLine()));
    }

    private static String reverseString(final String s) {
        String str = " " + s;
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        int j = str.length();
        while (i >= 0) {
            while (i >= 1 && str.charAt(i - 1) != ' ') i--;
            if (i < 0 || j < 0) break;
            sb.append(str.substring(i, j));
            sb.append(" ");
            j = i--;
            while (j >= 0 && str.charAt(j) != ' ') j--;
        }
        return new String(sb);
    }
}
