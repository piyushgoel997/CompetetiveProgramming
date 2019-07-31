import java.io.*;
import java.util.StringTokenizer;

public class EmailFromPolycarp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        for (int k = 0; k < n; k++) {
            String in = br.readLine();
            String out = br.readLine();

            int i = 0, j = 0;
            boolean isCorrect = true;
            while (true) {
                if (i >= in.length() && j >= out.length()) break;
                if (i >= in.length() || j >= out.length()) {
                    isCorrect = false;
                    break;
                }
                if (in.charAt(i) != out.charAt(j)) {
                    isCorrect = false;
                    break;
                }
                int ct1 = 0;
                while (i + ct1 < in.length() && in.charAt(i) == in.charAt(i + ct1)) ct1++;
                i += ct1;
                int ct2 = 0;
                while (j + ct2 < out.length() && out.charAt(j) == out.charAt(j + ct2)) ct2++;
                j += ct2;
                if (ct1 > ct2) {
                    isCorrect = false;
                    break;
                }
            }


            if (isCorrect) log.write("YES\n");
            else log.write("NO\n");
        }
        log.flush();
    }
}
