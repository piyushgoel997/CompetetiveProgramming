import java.util.HashSet;
import java.util.Scanner;

public class Romaji {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashSet<Character> vowels = new HashSet<>();
        char[] c = {'a', 'e', 'i', 'o', 'u'};
        for (char aC : c) {
            vowels.add(aC);
        }
        boolean prevC = false;
        for (int i = 0; i < s.length(); i++) {
            if (prevC) {
                if (!vowels.contains(s.charAt(i))) {
                    System.out.println("NO");
                    return;
                }
            }
            prevC = !vowels.contains(s.charAt(i));
            if (s.charAt(i) == 'n') prevC = false;
        }
        if (prevC) System.out.println("NO");
        else System.out.println("YES");
    }
}
