package SnackDown2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QBAC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            if (n < 3) {
                System.out.println("NIE");
                continue;
            }
            boolean possible = true;
            int i = 0;
            while (i < n - 2) {
                int m = b[i] - a[i];
                if (b[i] < a[i] || (m > 0 && i + 2 >= n)) {
                    possible = false;
                    break;
                }
                b[i] -= m;
                b[i + 1] -= 2 * m;
                b[i + 2] -= 3 * m;
                i++;
            }
            if (possible && (a[i] == b[i] && a[i + 1] == b[i + 1])) {
                System.out.println("TAK");
            } else {
                System.out.println("NIE");
            }
        }
    }
}
