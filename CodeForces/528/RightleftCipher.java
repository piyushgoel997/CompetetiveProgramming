import java.util.Scanner;

public class RightleftCipher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        if (str.length() <= 2) {
            System.out.println(str);
            return;
        }
        int n = str.length();
        int j = (n + 1) / 2;
        int i = j - 1;
        String ans = "";
        boolean possible = true;
        while (possible) {
            if (i >= 0) {
                ans += str.charAt(i);
                i--;
            }
            if (j < str.length()) {
                ans += str.charAt(j);
                j++;
            }
            if (i < 0 && j >= str.length()) {
                possible = false;
            }
        }
        System.out.println(ans);

    }
}
