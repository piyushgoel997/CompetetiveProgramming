package SnackDown2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuddyNIM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

            if (n == 1 && a[0] == 1) {
                System.out.println("Bob");
                continue;
            }

            if (n == m) {
                Arrays.sort(a);
                Arrays.sort(b);
                boolean same = true;
                for (int i = 0; i < n; i++) {
                    if (a[i] != b[i]) {
                        same = false;
                        break;
                    }
                }
                if (same) System.out.println("Bob");
                else System.out.println("Alice");
                continue;
            }
            System.out.println("Alice");
        }
    }
}
