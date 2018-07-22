package Searching;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 31-08-2017 at 14:38.
 * HackerRank. Searching, Graph/Tree - Medium. Correct.
 */
public class CutTheTree {

    // Important approach (also use in GraphTheory/EvenTree)

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) data[i] = s.nextLong();
        Graph g = new Graph(n, data);
        for (int i = 0; i < n - 1; i++) g.addEdge(s.nextInt() - 1, s.nextInt() - 1);
        long total = g.dfsCurrSum(0);
        long minDiff = Integer.MAX_VALUE;
        for (long sum : g.getSums()) {
            long c = Math.abs(total - 2 * sum);
            if (c < minDiff) minDiff = c;
        }
        System.out.println(minDiff);
    }

    static class Graph {
        private ArrayList<Integer>[] adjacencyList;
        private long[] nodesData;
        private long[] currSum;
        private boolean[] visited;

        Graph(int n, long[] data) {
            nodesData = data;
            currSum = new long[n];
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

        long dfsCurrSum(int s) {
            if (visited[s]) return 0;
            visited[s] = true;
            currSum[s] = nodesData[s];
            for (int child : adjacencyList[s]) currSum[s] += dfsCurrSum(child);
            return currSum[s];
        }

        long[] getSums() { return currSum; }
    }
}
