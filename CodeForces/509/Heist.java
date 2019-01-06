import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Heist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        long ans = max - min + 1 - n;

        if (ans > 0) System.out.println(ans);
        else System.out.println(0);
    }
}
