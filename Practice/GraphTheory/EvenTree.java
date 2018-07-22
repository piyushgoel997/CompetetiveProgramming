package GraphTheory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 02-09-2017 at 15:42.
 * HackerRank. GraphTheory - Medium. Correct.
 */
public class EvenTree {

    // Important approach (also used in Search/CutTheTree) - count the size of subtree of each node then iteratively check if that size is even
    //  since the size of tree is even (given) so no need to check for the other tree.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) g.addEdge(s.nextInt() - 1, s.nextInt() - 1);
        long total = g.fillSubtreeSize(0);
        int count = 0;
        for (long subtreeSize : g.getSizes()) {
            if (subtreeSize == total) continue;
            if (subtreeSize % 2 == 0) count++;
        }
        System.out.println(count);
    }

    static class Graph {
        private ArrayList<Integer>[] adjacencyList;
        private long[] subtreeSize;
        private boolean[] visited;

        Graph(int n) {
            subtreeSize = new long[n];
            adjacencyList = new ArrayList[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
                visited[i] = false;
            }

        }

        void addEdge(int u, int v) {
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        long fillSubtreeSize(int s) {
            // *IMP* return 0 because this is a tree and any node once visited should not be visited again.
            if (visited[s]) return 0;
            visited[s] = true;
            subtreeSize[s] = 1;
            for (int child : adjacencyList[s]) subtreeSize[s] += fillSubtreeSize(child);
            return subtreeSize[s];
        }

        long[] getSizes() { return subtreeSize; }
    }
}
