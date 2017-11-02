package Strings;

import java.util.Scanner;

/**
 * Created by piyus on 12-09-2017 at 18:39.
 * Strings, DP.
 */
public class LongestPalindromicSubstring {
    private static int[][] isPal;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            String str = s.next();
//            isPal = new int[str.length()][str.length() + 1];
//            isPalindrome(str, 0, str.length());
//            String longestPalindrome = "";
//            for (int i = 0; i < isPal.length; i++) {
//                for (int j = 0; j < isPal[0].length; j++) {
//                    if (j - i > longestPalindrome.length() && isPal[i][j] == 1) {
//                        longestPalindrome = str.substring(i, j);
//                    }
//                }
//            }
//            System.out.println(longestPalindrome);
            System.out.println(findLongestPalindrome(str));
        }
    }

    // Time Complexity - O(n^2), Space Complexity - O(n^2)
    private static int isPalindrome(String str, int start, int end) {
        if (start > end) return -1;
        if (end - start <= 1) return isPal[start][end] = 1;  // for len == 0 or 1
        if (isPal[start][end] != 0) return isPal[start][end];
        isPalindrome(str, start, end - 1);
        isPalindrome(str, start + 1, end);
        if (isPalindrome(str, start + 1, end - 1) == 1 && str.charAt(start) == str.charAt(end - 1)) {
            return isPal[start][end] = 1;
        } else {
            return isPal[start][end] = -1;
        }
    }

    // Non-DP Time Complexity = O(n^2), Space Complexity = O(1)
    private static String findLongestPalindrome(String string) {
        // iterate for strings of odd and even lengths, starting from centers.
        String longestPal = "";
        // odd - Fix a center and expand in both directions for longer palindromes.
        for (int i = 0; i < string.length(); i++) {
            int j = 0;
            for (; j <= Math.min(i, string.length() - 1 - i); j++) {
                if (string.charAt(i - j) != string.charAt(i + j)) break;
            }
            if ((2 * j) - 1 > longestPal.length()) { // -1 because j will be one more than it should have been.
                j--;
                longestPal = string.substring(i - j, i + j + 1);
            }
        }
        // even - Fix two centers and expand in both directions for longer palindromes.
        for (int i = 0; i < string.length() - 1; i++) {
            int j = 0;
            for (; j <= Math.min(i, string.length() - 2 - i); j++) {
                if (string.charAt(i - j) != string.charAt(i + j + 1)) {
                    break;
                }
            }
            if (2 * j > longestPal.length()) {
                j--;
                longestPal = string.substring(i - j, i + j + 2);
            }
        }
        return longestPal;
    }

}
