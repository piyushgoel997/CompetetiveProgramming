import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CreatingTheContest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        int i = 0;
        int j = 0;
        int max = 1;
        while (j < n - 1) {
            if (a[j+1] <= 2 * a[j]) {
                max = Math.max(j - i + 2, max);
                j++;
            } else {
                j++;
                i = j;
            }
        }
        System.out.println(max);
    }
}
