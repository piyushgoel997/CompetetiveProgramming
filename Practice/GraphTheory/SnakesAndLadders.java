package GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by piyus on 02-09-2017 at 21:36.
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            DiGraph board = new DiGraph(100);
            boolean[] oneWay = new boolean[100];
            for (int i = 0; i < 100; i++) oneWay[i] = false;
            for (int i = 0; i < n; i++) {
                int from = s.nextInt() - 1;
                board.addEdge(from, s.nextInt() - 1, 0);
                oneWay[from] = true;
            }
            int m = s.nextInt();
            for (int i = 0; i < m; i++) {
                int from = s.nextInt() - 1;
                board.addEdge(from, s.nextInt() - 1, 0);
                oneWay[from] = true;
            }
            for (int i = 0; i < 100; i++) {
                if (!oneWay[i]) {
                    for (int j = 1; j <= 6 && i + j < 100; j++) {
                        board.addEdge(i, i + j, j);
                    }
                }
            }
            System.out.println(board.bfsSP(0, 99, oneWay));
        }
    }

    private static class DiGraph {

        private static class DirectedEdge {
            int to;
            int from;
            int weight;

            public DirectedEdge(int from, int to, int weight) {
                this.to = to;
                this.from = from;
                this.weight = weight;
            }
        }

        ArrayList<DirectedEdge>[] adjacencyList;
        int V;
        int[] sp;

        DiGraph(int v) {
            V = v;
            adjacencyList = new ArrayList[V];
            for (int i = 0; i < V; i++) adjacencyList[i] = new ArrayList<>();
        }

        void addEdge(int from, int to, int weight) {
            adjacencyList[from].add(new DirectedEdge(from, to, weight));
        }

        int bfsSP(int from, int to, boolean[] oneWay) {
            LinkedList<Integer> q = new LinkedList<>();
            sp = new int[100];
            q.add(from);
            while (!q.isEmpty()) {
                int v = q.remove();
                for (DirectedEdge e : adjacencyList[v]) {
                    if (sp[e.to] == 0) {
                        q.add(e.to);
                        if (!oneWay[v]){ sp[e.to] = sp[v] + 1;} else sp[e.to] = sp[v];
                        if (e.to == to) return sp[to];
                    }
                }
            }
            return -1;
        }
    }
}
