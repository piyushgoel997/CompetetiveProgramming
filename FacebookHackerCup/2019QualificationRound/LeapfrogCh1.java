import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeapfrogCh1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            if (str.length() == 2) {
                System.out.println("Case #" + (t + 1) + ": N");
                continue;
            }
            int b = 0;
            for (int i = 0; i < str.length(); i++) if (str.charAt(i) == 'B') b++;
            if (b >= str.length() / 2 && b < str.length() - 1) System.out.println("Case #" + (t + 1) + ": Y");
            else System.out.println("Case #" + (t + 1) + ": N");
        }
    }
}
