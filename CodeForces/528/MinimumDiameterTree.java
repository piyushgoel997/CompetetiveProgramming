import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MinimumDiameterTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ArrayList[] tree = new ArrayList[n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (tree[x] == null) tree[x] = new ArrayList<Integer>();
            if (tree[y] == null) tree[y] = new ArrayList<Integer>();
            tree[x].add(y);
            tree[y].add(x);
        }
        int ct = 0;
        for (int i = 0; i < tree.length; i++) if (tree[i].size() == 1) ct++;
        System.out.println((1.0 * s * 2) / ct);
    }
}
