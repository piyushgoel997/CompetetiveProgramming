package Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyus on 28-08-2017 at 12:44.
 * HackerRank. Strings - Medium. Correct.
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }

    private static int sherlockAndAnagrams(String s) {
        int count = 0;
        for (int size = 1; size <= s.length(); size++)
            for (int i = 0; i +size<=s.length(); i++)
                for (int j = i + 1; j + size <= s.length(); j++)
                    if (checkAnagram(s.substring(i, i + size).toCharArray(), s.substring(j, j + size).toCharArray())) count++;
        return count;
    }

    private static boolean checkAnagram(char[] a, char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }


}
