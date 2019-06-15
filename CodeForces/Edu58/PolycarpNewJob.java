import java.io.*;
import java.util.StringTokenizer;

public class PolycarpNewJob {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long h = 0;
        long w = 0;
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            if (x > y) {
                long temp = x;
                x = y;
                y = temp;
            }
            if (c == '+') {
                h = Math.max(h, x);
                w = Math.max(w, y);
            } else {
                if (x >= h && y >= w) log.write("YES\n");
                else log.write("NO\n");
            }
        }
        log.flush();
    }
}
