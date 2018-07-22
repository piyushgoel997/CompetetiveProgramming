import java.util.Arrays;
import java.util.Scanner;

public class Springtime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String l = s.next();
        for (int i = 0; i < l.length() - 2; i++) {
            char[] temp = l.substring(i, i + 3).toCharArray();
            Arrays.sort(temp);
            if (String.valueOf(temp).equals("ABC")) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
