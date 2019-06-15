import java.util.Scanner;

public class Accordion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        StringBuilder sb = new StringBuilder();
        int x = -1;
        for (int i = 0; i < str.length(); i++) {
            if (sb.length() == 0) {
                if (str.charAt(i) == '[') sb.append(str.charAt(i));
                continue;
            }
            if (sb.length() == 1) {
                if (str.charAt(i) == ':') {
                    sb.append(str.charAt(i));
                    x = i;
                    break;
                }
            }
        }
        int y = -1;
        if (x != -1) for (int i = str.length() - 1; i > x; i--) {
            if (sb.length() == 2) {
                if (str.charAt(i) == ']') {
                    sb.append(str.charAt(i));
                }
                continue;
            }
            if (sb.length() == 3) {
                if (str.charAt(i) == ':') {
                    sb.append(str.charAt(i));
                    y = i;
                    break;
                }
            }
        }
        if (x!=-1&&y!=-1) for (int i = x + 1; i < y; i++) {
            if (str.charAt(i)=='|') sb.append(str.charAt(i));
        }
        if (x == -1 || y == -1) {
            System.out.println("-1");
        } else {
            System.out.println(sb.length());

        }
    }
}
