import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DivisionUnion {
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
                pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            }
            Arrays.sort(pairs, Comparator.comparingInt(Pair::getX));
            int i = 0;
            int max = pairs[0].y;
            for (; i < n - 1; i++) {
                max = Math.max(max, pairs[i].y);
                if (max < pairs[i+1].x) break;
            }
            if (i < n - 1) {
                int[] op = new int[n];
                for (int j = 0; j <= i; j++) {
                    op[pairs[j].idx] = 1;
                }
                for (int j = 0; j < n; j++) {
                    if (op[j] == 0) {
                        System.out.print("2 ");
                    } else
                        System.out.print("1 ");
                }
                System.out.println();
            } else {
                System.out.println("-1");
            }
        }
    }
    private static class Pair {
        int x;
        int y;
        int idx;

        public Pair(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int getX() {
            return x;
        }
    }
}
