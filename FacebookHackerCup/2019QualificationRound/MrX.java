import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MrX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            table = new int[str.length() + 1][str.length() + 1][3];
            for (int i = 0; i < str.length() + 1; i++) {
                for (int j = 0; j < str.length() + 1; j++) {
                    for (int k = 0; k < 3; k++) {
                        table[i][j][k] = -1;
                    }
                }
            }
            int ans = minimize(str, 0, str.length() - 1, -1);
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static int[][][] table;

    // reqdVal = -1 reps either 1 or 0
    private static int minimize(String str, int start, int end, int reqdVal) {

        if (table[start][end][reqdVal + 1] != -1) {
            return table[start][end][reqdVal + 1];
        }

        if (start == end) {
            if (reqdVal == 1 && str.charAt(start) != '1') return 1;
            if (reqdVal == 0 && str.charAt(start) != '0') return 1;
            if (reqdVal == -1 && (str.charAt(start) == 'x' || str.charAt(start) == 'X')) return 1;
            return 0;
        }

        int mid = start + 1;
        int open = 0;
        if (str.charAt(mid) == '(') {
            open++;
        }
        while (open != 0) {
            mid++;
            if (str.charAt(mid) == '(') {
                open++;
            } else if (str.charAt(mid) == ')') {
                open--;
            }
        }
        mid++;
        int[] ans = {9999, 9999, 9999};
        if (reqdVal == 1) {

            // make both 1
            ans[0] = minimize(str, start + 1, mid - 1, 1) + minimize(str, mid + 1, end - 1, 1);
        } else if (reqdVal == 0) {
            if (end - start == 4) {
                if (str.substring(start, end + 1).equals("(x&X)") || str.substring(start, end + 1).equals("(X&x)")) {
                    ans[0] = 0;
                }
            }
            // make either 0
            ans[0] = Math.min(ans[0], Math.min(minimize(str, start + 1, mid - 1, 0), minimize(str, mid + 1, end - 1, 0)));
        } else {
            if (end - start == 4) {
                if (str.substring(start, end + 1).equals("(x&X)") || str.substring(start, end + 1).equals("(X&x)")) {
                    ans[0] = 0;
                }
            }
            // either make both 1 or make either 0
            ans[0] = Math.min(ans[0], Math.min(Math.min(minimize(str, start + 1, mid - 1, 0),
                    minimize(str, mid + 1, end - 1, 0)),
                    minimize(str, start + 1, mid - 1, 1) + minimize(str, mid + 1, end - 1, 1)));
        }
        if (reqdVal == 1) {

            if (end - start == 4) {
                if (str.substring(start, end + 1).equals("(x|X)") || str.substring(start, end + 1).equals("(X|x)")) {
                    ans[1] = 0;
                }
            }
            // make either 1
            ans[1] = Math.min(ans[1], Math.min(minimize(str, start + 1, mid - 1, 1), minimize(str, mid + 1, end - 1, 1)));
        } else if (reqdVal == 0) {
            // make both 0
            ans[1] = minimize(str, start + 1, mid - 1, 0) + minimize(str, mid + 1, end - 1, 0);
        } else {
            if (end - start == 4) {
                if (str.substring(start, end + 1).equals("(x|X)") || str.substring(start, end + 1).equals("(X|x)")) {
                    ans[1] = 0;
                }
            }
            // either make either 1 or make both 0
            ans[1] = Math.min(ans[1], Math.min(Math.min(minimize(str, start + 1, mid - 1, 1), minimize(str, mid + 1, end - 1, 1)),
                    minimize(str, start + 1, mid - 1, 0) + minimize(str, mid + 1, end - 1, 0)));
        }
        if (reqdVal == 1) {

            if (end - start == 4) {
                if (str.substring(start, end + 1).equals("(x^X)") || str.substring(start, end + 1).equals("(X^x)")) {
                    ans[2] = 0;
                }
            }
            // make one 0 and other 1
            ans[2] = Math.min(ans[2], Math.min(minimize(str, start + 1, mid - 1, 1) + minimize(str, mid + 1, end - 1, 0),
                    minimize(str, start + 1, mid - 1, 0) + minimize(str, mid + 1, end - 1, 1)));
        } else if (reqdVal == 0) {
            if (end - start == 4) {
                if (str.substring(start, end + 1).equals("(x^x)") || str.substring(start, end + 1).equals("(X^X)")) {
                    ans[2] = 0;
                }
            }
            // either make both 0 or make both 1
            ans[2] = Math.min(ans[2], Math.min(minimize(str, start + 1, mid - 1, 0) + minimize(str, mid + 1, end - 1, 0),
                    minimize(str, start + 1, mid - 1, 1) + minimize(str, mid + 1, end - 1, 1)));
        } else {
            if (end - start == 4) {
                ans[2] = 0;
            }
            // either of the above 2
            ans[2] = Math.min(ans[2], Math.min(Math.min(minimize(str, start + 1, mid - 1, 1) + minimize(str, mid + 1, end - 1, 0),
                    minimize(str, start + 1, mid - 1, 0) + minimize(str, mid + 1, end - 1, 1)),
                    Math.min(minimize(str, start + 1, mid - 1, 0) + minimize(str, mid + 1, end - 1, 0),
                            minimize(str, start + 1, mid - 1, 1) + minimize(str, mid + 1, end - 1, 1))));
        }


        if (str.charAt(mid) == '&') {
            ans[1]++;
            ans[2]++;
        } else if (str.charAt(mid) == '|') {
            ans[0]++;
            ans[2]++;
        } else if (str.charAt(mid) == '^') {
            ans[0]++;
            ans[1]++;
        } else {
            System.out.println("Error");
            System.out.println(mid);
        }

        return table[start][end][reqdVal + 1] = Math.min(ans[0], Math.min(ans[1], ans[2]));
    }
}
