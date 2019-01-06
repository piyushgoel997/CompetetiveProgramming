import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Glider {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        long[] begin = new long[n];
        long[] end = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            begin[i] = Long.parseLong(st.nextToken());
            end[i] = Long.parseLong(st.nextToken());
        }
        int i = 0;
        int j = 0;
        long ch = h;
        long max = 0;

        while (j < n) {
            long nextHt = 0;
            if (j < n - 1) nextHt = ch - (begin[j + 1] - end[j]);
            if (nextHt > 0) {
                ch = nextHt;
                j++;
            } else {
                max = Math.max(max, end[j] - begin[i] + ch);
                if (i < n - 1) {
                    ch += begin[i + 1] - end[i];
                }
                else ch = h;
                ch = Math.min(ch, h);
                i++;
                if (j < i) j = i;
            }
        }
        System.out.println(max);
    }
}
