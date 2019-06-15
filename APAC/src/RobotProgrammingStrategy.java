import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RobotProgrammingStrategy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String[] progs = new String[a];
            boolean[] beaten = new boolean[a];
            Arrays.fill(beaten, false);
            for (int i = 0; i < a; i++) progs[i] = br.readLine();
            System.out.println("Case #" + (t + 1) + ": " + fn(0, progs, beaten, a));
        }
    }

    private static String fn(int i, String[] progs, boolean[] beaten, int a) {
        HashSet<Character> set = new HashSet<>();
        for (int j = 0; j < a; j++) {
            if (!beaten[j]) set.add(progs[j].charAt(i % (progs[j].length())));
        }
        if (set.size() == 2) {
            if (set.contains('R')) {
                if (set.contains('P')) {
                    update(i, 'R', progs, beaten, a);
                    String temp = fn(i + 1, progs, beaten, a);
                    if (temp == "IMPOSSIBLE") {
                        return temp;
                    }
                    return "P" + temp;
                } else {
                    update(i, 'S', progs, beaten, a);
                    String temp = fn(i + 1, progs, beaten, a);
                    if (temp == "IMPOSSIBLE") {
                        return temp;
                    }
                    return "R" + temp;
                }
            } else {
                update(i, 'P', progs, beaten, a);
                String temp = fn(i + 1, progs, beaten, a);
                if (temp == "IMPOSSIBLE") {
                    return temp;
                }
                return "S" + temp;
            }
        } else if (set.size() == 1) {
            if (set.contains('R')) {
                return "P";
            } else if (set.contains('P')) {
                return "S";
            } else {
                return "R";
            }
        } else if (set.size() == 3) {
            return "IMPOSSIBLE";
        } else {
            return "";
        }
    }

    private static void update(int i, char c, String[] progs, boolean[] beaten, int a) {
        for (int j = 0; j < a; j++) if (!beaten[j] && progs[j].charAt(i % (progs[j].length())) == c) beaten[j] = true;
    }

}
