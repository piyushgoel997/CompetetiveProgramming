import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PlanetDistance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int[][] tubes = new int[n][n];
            for (int i = 0; i < n; i++) {
                int x = s.nextInt() - 1;
                int y = s.nextInt() - 1;
                tubes[x][y] = 1;
                tubes[y][x] = 1;
            }
            cycle = new HashSet<>();
            Set<Integer> notVisited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                notVisited.add(i);
            }
            last = -1;
            inCycle(0, -1, tubes, notVisited, n);

            // find dist using bfs
            dist = new int[n];
            for (int i = 0; i < n; i++) {
                if (!cycle.contains(i)) {
                    dist[i] = -1;
                }
            }
            System.out.print("Case #" + (t + 1) + ": ");
            for (int i = 0; i < n; i++) {
                System.out.print(findDist(i,-1, tubes, n));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static int[] dist;

    private static int findDist(int curr, int prev, int[][] tubes, int n) {
        if (dist[curr] != -1) {
            return dist[curr];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i != prev && tubes[curr][i] == 1) {
                int d = findDist(i, curr, tubes, n);
                if (d < 0) d = Integer.MAX_VALUE;
                min = Math.min(d, min);
            }
        }
        if (min != Integer.MAX_VALUE) {
            dist[curr] = min + 1;
        }
        return min + 1;
    }

    private static Set<Integer> cycle;
    private static int last;

    private static boolean inCycle(int curr, int prev, int[][] tubes, Set<Integer> notVisited, int n) {
        if (!notVisited.contains(curr)) {
            last = curr;
            return true;
        }
        notVisited.remove(curr);
        for (int i = 0; i < n; i++) {
            if (i != prev && tubes[curr][i] == 1) {
                boolean x = inCycle(i, curr, tubes, notVisited, n);
                if (x) {
                    cycle.add(curr);
                    if (curr == last) {
                        return false;
                    }else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

