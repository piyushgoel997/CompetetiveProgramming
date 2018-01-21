import java.util.*;

/**
 * Created by piyus on 23-12-2017 at 20:32.
 */
public class Shockers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Set<Character> hm = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            hm.add(c);
        }
        int shocks = 0;
        s.nextLine();
        boolean b = true;
        for (int i = 0; i < n; i++) {
            String str = s.nextLine();
//            System.out.println(str.charAt(0));
            switch (str.charAt(0)) {
                case '!':
                    if (hm.size() > 1) {
                        Set<Character> temp = new HashSet<>();
                        for (int j = 2; j < str.length(); j++) temp.add(str.charAt(j));
                        hm.retainAll(temp);
                    }
                    shocks++;
                    break;
                case '.':
                    if (hm.size() > 1) {
                        for (int j = 2; j < str.length(); j++) {
                            if (hm.contains(str.charAt(j))) hm.remove(str.charAt(j));
                        }
                    }
                    break;
                case '?':
                    if (hm.size() > 1) if (hm.contains(str.charAt(2))) hm.remove(str.charAt(2));
                    if (i < n - 1) shocks++;
            }
//            System.out.println(hm.size());
            if (b && hm.size() == 1) {
                b = false;
                shocks = 0;
            }
        }
//        System.out.println(shocks);
        if (hm.size() == 1) {
            System.out.println(shocks);
        } else {
            System.out.println(0);
        }
    }
}
