package SnackDown2019;

import java.util.HashSet;
import java.util.Scanner;

public class TYPING {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            HashSet<String> set = new HashSet<>();
            long time = 0;
            for (int i = 0; i < n; i++) {
                String str = s.next();
                if (set.contains(str)) time += calcTime(str) / 2;
                else time += calcTime(str);
                set.add(str);
            }
            System.out.println(time);
        }
    }

    private static long calcTime(String str) {
        long time = 2;
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (((prev == 'd' || prev == 'f') && (c == 'j' || c == 'k')) || ((prev == 'j' || prev == 'k') && (c == 'd' || c == 'f')))
                time += 2;
            else time += 4;
            prev = c;
        }
        return time;
    }
}
