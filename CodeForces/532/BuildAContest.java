import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BuildAContest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] probs = new int[n];
        HashSet<Integer> notPresent = new HashSet<>();
        for (int i = 0; i < n; i++) notPresent.add(i);
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            probs[x] += 1;
            notPresent.remove(x);
            if (notPresent.isEmpty()) {
                sb.append(1);
                for (int j = 0; j < n; j++) {
                    probs[j] -= 1;
                    if (probs[j] == 0) {
                        notPresent.add(j);
                    }
                }
            } else {
                sb.append(0);
            }
        }
        System.out.println(sb);
    }
}
