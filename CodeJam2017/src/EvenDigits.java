import java.util.Scanner;

public class EvenDigits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            String in = s.next();
            System.out.println("Case #" + (t + 1) + ": " + Math.abs(Long.parseLong(in) - Long.parseLong(nearestEven(in))));
        }
    }

    private static String nearestEven(String s) {
        String op = "";
        String a = "";
        String b = "";
        for (int i = 0; i < s.length(); i++) {
            int c = Integer.parseInt(s.substring(i, i + 1));
            if (c % 2 == 0) {
                op = op + c;
                if (i == s.length() - 1) {
                    return s;
                }
            } else {
                a = String.valueOf(c + 1);
                b = String.valueOf(c - 1);
                for (int j = i + 1; j < s.length(); j++) {
                    a += "0";
                    b += "8";
                }

                if (c + 1 >= 10) {
                    if (op != "") {
                        a = String.valueOf(nearestEven(String.valueOf(Long.parseLong(op) + 1))) + a.substring(1);
                    } else {
                        if (Integer.parseInt(a.substring(0, 1)) % 2 == 1) {
                            a = String.valueOf(Integer.parseInt(a.substring(0, 1)) + 1) + a.substring(1);
                        }
                    }
                } else {
                    a = op + a;
                }
                b = op + b;
                break;
            }
        }
        long x = Math.abs(Long.parseLong(a) - Long.parseLong(s));
        long y = Math.abs(Long.parseLong(s) - Long.parseLong(b));
        return x < y ? a : b;
    }


}
