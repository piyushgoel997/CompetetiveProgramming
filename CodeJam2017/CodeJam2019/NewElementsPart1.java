import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NewElementsPart1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                pairs[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }

            HashSet<Double> ratios = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (pairs[i].c == pairs[j].c || pairs[i].j == pairs[j].j) continue;
                    if (pairs[i].c > pairs[j].c && pairs[i].j > pairs[j].j) continue;
                    if (pairs[i].c < pairs[j].c && pairs[i].j < pairs[j].j) continue;
                    ratios.add(Math.abs((1.0 * (pairs[i].c - pairs[j].c)) / (1.0 * (pairs[i].j - pairs[j].j))));
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + (ratios.size() + 1));
        }
    }

    private static class Pair {
        long c;
        long j;

        Pair(long c, long j) {
            this.c = c;
            this.j = j;
        }
    }
}
