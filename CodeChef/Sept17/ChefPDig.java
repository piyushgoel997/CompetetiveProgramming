package Sept17;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by piyus on 04-09-2017 at 19:23.
 */
public class ChefPDig {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            String n = s.next();
            boolean[] alpha = new boolean[(int) 'Z' + 1];
            for (int i = 0; i < alpha.length; i++) alpha[i] = false;
            int toggles = 0;
            for (int i = 0; i < n.length() - 1; i++) {
                for (int j = i + 1; j < n.length(); j++) {
                    int a = Integer.parseInt("" + n.charAt(i) + n.charAt(j));
                    if (a <= (int) 'Z' && a >= (int) 'A'){
                        if (!alpha[(char) a]) toggles++;
                        alpha[(char) a] = true;
                    }
                    if (n.charAt(i) == n.charAt(j)) break;
                    int b = Integer.parseInt("" + n.charAt(j) + n.charAt(i));
                    if (b <= (int) 'Z' && b >= (int) 'A'){
                        if (!alpha[(char) b]) toggles++;
                        alpha[(char) b] = true;
                    }
                    if (toggles >= 'Z' - 'A' + 1) break;
                }
                if (toggles >= 'Z' - 'A' + 1) break;
            }
            for (int i = (int) 'A'; i <= 'Z'; i++) if (alpha[i]) System.out.print((char) i);
            System.out.println();
        }
    }
}
