import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GCDCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] values = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) values[i] = Integer.parseInt(st.nextToken());
        HashSet<Integer>[] connections = new HashSet[n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (connections[x] == null) connections[x] = new HashSet<Integer>();
            if (connections[y] == null) connections[y] = new HashSet<Integer>();
            connections[x].add(y);
            connections[y].add(x);
        }
        table = new HashMap[n];
//        dp(0, values[0], values, connections);
    }

    private static HashMap<Integer, Integer>[] table;

//    private static HashMap<Integer, Integer> dp(int curr, int gcd, int[] values, HashSet<Integer>[] connections) {
//        for (int i : connections[curr]) {
//            if (i == curr) continue;
//        }
//    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    private static class Pair {
        int x;
        int y;
    }
}
