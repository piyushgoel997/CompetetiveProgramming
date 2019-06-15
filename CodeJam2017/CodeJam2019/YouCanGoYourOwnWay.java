import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YouCanGoYourOwnWay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            br.readLine();
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'S') sb.append('E');
                else sb.append('S');
            }
            System.out.println("Case #" + (t + 1) + ": " + sb);
        }
    }
}
