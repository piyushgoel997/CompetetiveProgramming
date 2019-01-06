import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String t = s.next();
        char n = t.charAt(0);
        char x = t.charAt(1);
        boolean p = false;
        for (int i = 0; i < 5; i++) {
            String str = s.next();
            if (str.charAt(0) == n || str.charAt(1) == x) {
                p = true;
            }
        }
        if (p) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
