package ICPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class icpc3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = br.readLine();
            HashSet<String> totalSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                totalSet.add(arr[i]);
                totalSet.add(new StringBuilder(arr[i]).reverse().toString());
            }
            for (int i = 0; i < n - 3; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i].charAt(j));
                    sb.append(arr[i+1].charAt(j));
                    sb.append(arr[i+2].charAt(j));
                    sb.append(arr[i+3].charAt(j));
                    totalSet.add(sb.toString());
                    totalSet.add(sb.reverse().toString());
                }
            }
            System.out.println(totalSet.size());
            HashSet<Integer> ans = new HashSet<>();
            int x = -1;
            for (int i = 0; i < n - 3; i++) {
                HashSet<String> curr = new HashSet<>();
                for (int j = 0; j < 4; j++) {
                    curr.add(arr[i + j]);
                    curr.add(new StringBuilder(arr[i + j]).reverse().toString());
                }
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i].charAt(j));
                    sb.append(arr[i+1].charAt(j));
                    sb.append(arr[i+2].charAt(j));
                    sb.append(arr[i+3].charAt(j));
                    totalSet.add(sb.toString());
                    totalSet.add(sb.reverse().toString());
                }
                if (curr.size() == totalSet.size()) {
                    ans.add(i);
                    x = i;
                }
                System.out.println(curr.size());
            }
            if (ans.size() >= 1) {
                for (int i : ans) {
                    if (x == i) continue;
                    for (int j = 0; j < 16; j++) {
                        if (arr[x + j / 4].charAt(j % 4) > arr[i + j / 4].charAt(j % 4)) {
                            x = i;
                            break;
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    System.out.println(arr[x + i]);
                }
            } else {
                System.out.println("grid\n" +
                        "snot\n" +
                        "poss\n" +
                        "ible");
            }
            System.out.println();
        }
    }
}
