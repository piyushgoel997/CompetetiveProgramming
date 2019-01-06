import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CircularDance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Node[][] find = new Node[n + 1][2];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node();
            nodes[i].x = x;
            nodes[i].y = y;
            if (find[x][0] == null) find[x][0] = nodes[i];
            else find[x][1] = nodes[i];
            if (find[y][0] == null) find[y][0] = nodes[i];
            else find[y][1] = nodes[i];
        }
        Node curr = nodes[0];
        int a = curr.x;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(a + " ");
            a = curr.other(a);
            if (find[a][0] == curr) curr = find[a][1];
            else curr = find[a][0];
            if (curr == nodes[0]) break;
        }
        boolean rev = false;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                int x = sb.charAt((i + 2) % n);
                if (nodes[0].x == x || nodes[0].y == x) {
                    rev = false;
                } else {
                    rev = true;
                }
                break;
            }
        }
        if (rev) System.out.println(sb.reverse().toString().substring(1));
        else System.out.println(sb);
    }

    static class Node {
        int x;
        int y;

        public int other(int a) {
            if (x == a) return y;
            return x;
        }
    }
}
