package CCRT10;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inp = s.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inp.length(); i++) {
            if (i == 0) sb.append(cap(inp.charAt(i)));
            else if (inp.charAt(i) == '_') {
                sb.append(' ');
                i++;
                sb.append(cap(inp.charAt(i)));
            } else {
                sb.append(lower(inp.charAt(i)));
            }
        }
        System.out.println(sb);
    }

    private static char lower(char c) {
        if (c < 'a') return (char) (c + 'a' - 'A');
        return c;
    }

    private static char cap(char c) {
        if (c > 'Z') return (char) (c - 'a' + 'A');
        return c;
    }
}
