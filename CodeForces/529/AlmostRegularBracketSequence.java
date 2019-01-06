import java.util.Scanner;

public class AlmostRegularBracketSequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        int[] open = new int[n + 1];
        int[] close = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                open[i + 1] = open[i] + 1;
                close[i + 1] = close[i];
            }
            else {
                close[i + 1] = close[i] + 1;
                open[i + 1] = open[i];
            }
        }
        if (open[n] == close[n] || Math.abs(open[n] - close[n]) > 1) {
            System.out.println(0);
            return;
        }
        int ct = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {

            }
        }
    }
}
