import java.util.Scanner;

/**
 * Created by piyus on 27-06-2017 at 12:49.
 * Kickstart Round C 2017 C
 */
public class MagicalThinking {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int ans = solve();
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static int solve() {
        int n = s.nextInt();
        int q = s.nextInt();
        if (n == 1) return one(q); // for small input
        return two(q);
    }

    private static int two(int q) {
        String f = s.next();  // friend's answers
        String g = s.next();  // friend 2
        String m = s.next();  // my ans
        int c = s.nextInt();  // no. of correct ans of friend 1
        int d = s.nextInt();  // no. of correct ans of friend 2
        int[] match = new int[4];
        // 0 - same ans of all 3 ex - TTT
        // 1 - 1 and me are same      TFT
        // 2 - 2 and me are same      FTT
        // 3 - 1 and 2 are same       TTF
        for (int i = 0; i < q; i++) {
            if (f.charAt(i) == g.charAt(i)) {
                if (f.charAt(i) == m.charAt(i)) {
                    match[0]++;
                } else {
                    match[3]++;
                }
            } else {
                if (f.charAt(i) == m.charAt(i)) {
                    match[1]++;
                } else {
                    match[2]++;
                }
            }
        }

        return 0;
    }

    private static int one(int q) {
        String f = s.next();  // friend's answers
        String m = s.next();  // my ans
        int c = s.nextInt();  // no. of correct ans of friend
        int same = 0;  // no. of same ans
        for (int i = 0; i < q; i++) {
            if (m.charAt(i) == f.charAt(i)) same++;
        }
        if (same > c) {
            return q + c - same;
        }
        return q - c + same;
    }
}
