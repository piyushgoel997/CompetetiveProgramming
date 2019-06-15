import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NewsDistribution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] neighbours = new HashSet[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] curr = new int[size];
            for (int j = 0; j < size; j++) {
                curr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (j == k) continue;
                    neighbours[curr[j]].add(curr[k]);
                    neighbours[curr[k]].add(curr[j]);
                }
            }
        }



        int[] numUsers = new int[n];
        Arrays.fill(numUsers, -1);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            numUsers[i] = dfs(i, neighbours, visited);
            for (int j = 0; j < n; j++) {
                if (numUsers[j] == -1 && visited[j]) {
                    numUsers[j] = numUsers[i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(numUsers[i]+" ");
        }
    }

    private static int dfs(int i, HashSet<Integer>[] neighbours, boolean[] visited) {
        if (visited[i]) return 0;
        int sum = 1;
        visited[i] = true;
        for (Integer x : neighbours[i]) {
            if (visited[x]) continue;
            sum += dfs(x, neighbours, visited);
        }
        return sum;
    }

}
