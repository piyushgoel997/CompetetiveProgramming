package SnackDown2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ARRGRAPH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[][] gcd = new int[51][51];
        for (int i = 2; i < 51; i++) {
            for (int j = 2; j < 51; j++) {
                gcd[i][j] = gcd(i, j);
                gcd[j][i] = gcd[i][j];
            }
        }
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
            int[] set = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (gcd[arr[i]][arr[j]] == 1) set[j] = i;
                    else set[j] = j;
                }
            }
            for (int i = 0; i < n; i++) {
                int j = set[i];
                int prev = i;
                while (prev != j) {
                    prev = j;
                    j = set[j];
                }
                set[i] = j;
            }
            boolean connected = true;
            for (int i = 0; i < n - 1; i++) {
                if (set[i] != set[i + 1]) {
                    connected = false;
                    break;
                }
            }
            if (connected) {
                System.out.println(0);
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i]);
                    System.out.print(" ");
                }
            } else {
                System.out.println(1);
                System.out.print("47 ");
                for (int i = 1; i < n; i++) {
                    System.out.print(arr[i]);
                    System.out.print(" ");
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
