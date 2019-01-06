import java.util.Scanner;

public class PalindromicTwist {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            String str = s.next();
            boolean possible = true;
            for (int i = 0; i < n / 2; i++) {
                if (str.charAt(i) + 1 != str.charAt(n - 1 - i) + 1 && str.charAt(i) + 1 != str.charAt(n - 1 - i) - 1 && str.charAt(i) - 1 != str.charAt(n - 1 - i) + 1 && str.charAt(i) - 1 != str.charAt(n - 1 - i) - 1) {
                    possible = false;
                    break;
                }
            }
            if (possible){ System.out.println("YES");}
            else System.out.println("NO");
        }
    }
}
