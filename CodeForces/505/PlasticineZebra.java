import java.util.Scanner;

public class PlasticineZebra {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();

        int start = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) start++;
            else break;
        }
        if (start == str.length()) {
            System.out.println(start);
            return;
        }
        int end = 1;
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) != str.charAt(i - 1)) end++;
            else break;
        }
        int max = 0;
        int curr = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        max = Math.max(max, curr);
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            start = start + end;
        }
        System.out.println(Math.max(start, max));

    }
}
