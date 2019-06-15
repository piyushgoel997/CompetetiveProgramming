import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TelephoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            br.readLine();
            String str = br.readLine();
            int i = 0;
            for (; i < str.length(); i++) if (str.charAt(i) == '8') break;
            if (str.length() - i >= 11) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
