package ICPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class icpc1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            if (n == 1) {
                System.out.println(arr[0]);
                continue;
            }
            Arrays.sort(arr);
            if (n == 2) {
                if (arr[0] > k) {
                    arr[1] -= arr[0] - k;
                    arr[0] = k;
                }
                System.out.println(arr[0] + arr[1]);
                continue;
            }
            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (i == n - 2 && arr[i] > k) {
                    arr[n - 1] = arr[n - 1] - (arr[n - 2] - k);
                    arr[n - 2] = k;
                } else if (arr[i] > k) {
                    arr[n - 2] = arr[n - 2] - (arr[i] - k);
                    arr[i] = arr[i] - (arr[i] - k);
                }
                sum += arr[i];
                Arrays.sort(arr);
            }
            sum += arr[n - 1];
            System.out.println(sum);
        }
    }
}
