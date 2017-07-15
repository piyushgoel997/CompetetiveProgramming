import java.util.Scanner;

/**
 * Created by piyus on 27-06-2017 at 10:25.
 * Kickstart Round C 2017 A.
 */
public class AmbiguousCipher {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            String str = s.next();
            String ans = solve(str);
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static String solve(String str) {
        int[][] d = new int[2][str.length()];
        for (int i = 0; i < str.length(); i++) {
            d[0][i] = (int) (str.charAt(i)) - 65;
            d[1][i] = d[0][i] + 26;
        }
        d[1][0] = -1;
        d[1][str.length() - 1] = -1;
        int[] word = new int[str.length()];
        for (int i = 0; i < word.length; i++) {
            word[i] = -1;
        }
        word[1] = d[0][0];
        word[str.length() - 2] = d[0][str.length() - 1];
        for (int j = 0; j < str.length(); j++) {
            for (int i = 1; i < str.length() - 1; i++) {
                if (word[i - 1] != -1 && word[i + 1] == -1) {
                    word[i + 1] = d[0][i] - word[i - 1];
                    if (word[i + 1] < 0) {
                        word[i + 1] = d[1][i] - word[i - 1];
                    } else if (d[1][i] - word[i - 1] > 0 && (d[1][i] - word[i - 1])%26 != word[i + 1]) {
                        return "AMBIGUOUS";
                    }
                }

                if (word[i + 1] != -1 && word[i - 1] == -1) {
                    word[i - 1] = d[0][i] - word[i + 1];
                    if (word[i - 1] < 0) {
                        word[i - 1] = d[1][i] - word[i + 1];
                    } else if (d[1][i] - word[i + 1] > 0 && (d[1][i] - word[i + 1]) % 26 != word[i - 1]) {
                    return "AMBIGUOUS";
                    }
                }
            }
        }
        String ans = "";
        for (int i = 0; i < word.length; i++) {
            if (word[i] < 0) {
                return "AMBIGUOUS";
            }


            ans += Character.toString((char) (word[i] + 65));
        }

        return ans;
    }
}



