import java.util.Scanner;

public class MagicalSubsequence {


    public static void main(String[] args) {
//        X a = new X("A");
//        X b = new X("B");
//        b.start();
//        a.start();
        System.out.println(longestSubsequence("aeiouuuueeeeeeeiooooooouuuuu"));
    }

    static int longestSubsequence(String s) {
        table = new int[s.length() + 1][5];
        dict = new char[]{'a', 'e', 'i', 'o', 'u'};
        if (!check(s)) return 0;
        int lastU = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'u') {
                lastU = i;
                break;
            }
        }
        return Math.max(0, dp(s, 0, 0, lastU) - 9999);
    }

    static boolean check(String s) {
        boolean a = false;
        boolean e = false;
        boolean i = false;
        boolean o = false;
        boolean u = false;
        for (int j = 0; j < s.length(); j++) {
            if (!a) {
                if (s.charAt(j) == 'a') a = true;
            }
            else if (!e) {
                if (s.charAt(j) == 'e') e = true;
            }
            else if (!i) {
                if (s.charAt(j) == 'i') i = true;
            }
            else if (!o) {
                if (s.charAt(j) == 'o') o = true;
            }
            else if (!u) {
                if (s.charAt(j) == 'u') return true;
            }
        }
        return false;
    }

    static int[][] table;
    static char[] dict;
    static int dp(String s, int idx, int letter, int lastU) {
        if (idx >= s.length()) return 0;
        if (idx == lastU) {
            if (letter < 4) {
                return 0;
            }
            return 10000;
        }
        if (table[idx][letter] > 0) return table[idx][letter];
        int max = 0;
        for (int i = letter; i <= letter + 1 && i < 5; i++) {
            max = Math.max(max, dp(s, idx + 1, i, lastU));
        }
        if (dict[letter] == s.charAt(idx)) max++;
        return table[idx][letter] = max;
    }

    private static class X implements Runnable {
        private Thread t;
        private String name;

        X(String name) {
            this.name = name;
        }

        public void run() {
            while (true) {
                System.out.println(name);
            }
        }

        public void start() {
            if (t == null) {
                t = new Thread(this, name);
                t.start();
            }
        }
    }

}
