import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TreasureGeolocation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Pair[] xy = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xy[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Pair[] ab = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ab[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(xy, Comparator.comparingInt(p -> p.x));
        Arrays.sort(ab, Comparator.comparingInt(p -> p.x));
        Pair max = xy[n - 1];
        int i = n - 1;
        while (i >= 0 && xy[i].x == max.x) {
            if (xy[i].y > max.y) max = xy[i];
            i--;
        }
        Pair min = ab[0];
        i = 0;
        while (i < n && ab[i].x == min.x) {
            if (xy[i].y < min.y) min = ab[i];
            i++;
        }
        System.out.println((max.x + min.x) + " " + (max.y + min.y));
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
