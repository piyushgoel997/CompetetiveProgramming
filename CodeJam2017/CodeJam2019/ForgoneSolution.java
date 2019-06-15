import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ForgoneSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '4') {
                    a.append('3');
                    b.append('1');
                } else {
                    a.append(str.charAt(i));
                    b.append('0');
                }
            }
            System.out.print("Case #" + (t + 1) + ": " + a + " ");
            int i = 0;
            while (b.charAt(i) == '0') i++;
            System.out.print(b.subSequence(i, b.length()));
            System.out.println();
        }
    }
}
