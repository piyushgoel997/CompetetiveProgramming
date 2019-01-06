package ICPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class icpc2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] u = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) u[i] = Long.parseLong(st.nextToken());
        long[] l = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) l[i] = Long.parseLong(st.nextToken());
        tree = new long[4 * n + 1];
//        construct(u, 0, n - 1, 0);
    }

//    private static long construct(long[] u, int s, int e, int i) {
//        if (s == e) {
//            tree[i] = u[s];
//
//        }
//    }

    static long[] tree;
}
