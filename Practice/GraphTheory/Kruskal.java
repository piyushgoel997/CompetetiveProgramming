package GraphTheory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by piyus on 02-09-2017 at 16:15.
 * HackerRank. GraphTheory - Medium. Correct.
 * Prim's question can also be solved by the same code.
 */
public class Kruskal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Graph g = new Graph(m, n);
        for (int i = 0; i < m; i++) g.addEdge(s.nextInt() - 1, s.nextInt() - 1, s.nextInt());
        ArrayList<Edge> edges = g.edges();
        edges.sort((Comparator.comparingInt(Edge::getWeight)).thenComparing(e -> e.getU() + e.getV() + e.getWeight()));
        long totalWt = 0;
        UF uf = new UF(n);
        for (Edge e : edges) {
            if (!uf.connected(e.u,e.v)) {
                totalWt += e.weight;
                uf.union(e.u, e.v);
            }
        }
        System.out.println(totalWt);
    }

    static class Edge {
        int u;
        int v;
        int weight;

        int getU() {
            return u;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class Graph {
        ArrayList<Edge>[] adjacencyList;
        int E;
        int V;

        Graph(int e, int v) {
            E = e;
            V = v;
            adjacencyList = new ArrayList[V];
            for (int i = 0; i < V; i++) adjacencyList[i] = new ArrayList<>();
        }

        void addEdge(int u, int v, int wt) {
            adjacencyList[u].add(new Edge(u, v, wt));
            adjacencyList[v].add(new Edge(u, v, wt));
        }

        ArrayList<Edge> edges() {
            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < V; i++) edges.addAll(adjacencyList[i]);
            return edges;
        }
    }

    static class UF {

        private int[] id;

        public UF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public void union(int x, int y) {
            int idy = id[y];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == idy) {
                    id[i] = id[x];
                }
            }
        }

        public boolean connected(int x, int y) {
            return id[x] == id[y];
        }

    }

}
