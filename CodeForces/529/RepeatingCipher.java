import java.util.Scanner;

public class RepeatingCipher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        String op = "";
        int i = 0;
        int j = 1;
        while (i < str.length()) {
            op += str.charAt(i);
            i += j;
            j++;
        }
        System.out.println(op);
    }
}
