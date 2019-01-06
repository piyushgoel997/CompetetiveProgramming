import java.util.ArrayList;
import java.util.HashSet;

public class InvadesScoobyLand {
    public static void main(String[] args) {
        int n = 20;
        int k = 200;
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 2; i <= 20; i++) {
            C.add(i);
        }
        ArrayList<Integer> D = new ArrayList<>();
        int[] x = {1, 1, 3, 2, 5,1,1,2,7,10,3,7,8,12,6,6,10,1,8};
        for (int i = 0; i < x.length; i++) {
            D.add(x[i]);
        }
        System.out.println(solve(n, k, C, D));
    }
    public static int solve(int A, int B, ArrayList<Integer> C, ArrayList<Integer> D) {
        int ct = 0;
        Node[] graph = new Node[A + 1];
        makeGraph(graph, C, D);
        for (int i = 0; i < C.size(); i++) {
            HashSet<Integer> x = new HashSet<>();
            HashSet<Integer> y = new HashSet<>();

            graph[C.get(i)].neighbours.remove(graph[D.get(i)]);
            graph[D.get(i)].neighbours.remove(graph[C.get(i)]);

            visited = new boolean[A + 1];
            dfs(graph, C.get(i), x);
            dfs(graph, D.get(i), y);

            if (x.size() + y.size() == A && x.size()%2 == 0 && y.size()%2 == 0) {
                ct++;
            }

            graph[C.get(i)].neighbours.add(graph[D.get(i)]);
            graph[D.get(i)].neighbours.add(graph[C.get(i)]);
        }
        System.out.println(ct);
        // process ct

        if (ct > B) {
            return 0;
        }

        long mod = 1000000007;
//        long ans = 1;
//        for (int i = 1; i <= ct; i++) {
//            ans = (ans * i) % mod;
//        }
//        for (int i = 0; i < B - ct; i++) {
//            ans = (ans * ct) % mod;
//        }

//        long ans = sumupto(B - 1, mod) - sumupto(ct - 1, mod) + 1;


        return (int) calc(ct, B, mod);

    }

    static long calc(int x, int k, long mod) {
        long ans = 1;
        for (int i = 0; i < k - x; i++) {
            ans = (ans * (x + 1)) % mod;
        }
        for (int i = k - x + 1; i <= k; i++) {
            ans = (ans * i) % mod;
        }
        for (int i = 1; i <= x; i++) {
            ans = (ans / i) % mod;
        }
        return ans;
    }

    static long fact(int k, long mod) {
        long ans = 1;
        for (long i = 2; i <= k; i++) {
            ans = ((ans % mod) * (i % mod)) % mod;
        }
        return ans;
    }

    private static long temp(int x, int k, long mod) {
        long ans = 0;
        boolean add = true;
        for (int i = x -1; i > 0; i--) {
            long temp = 1;

            for (int j = 0; j <= k; j++) {
                temp = (temp * i) % mod;
            }

            if (add) ans = (temp + ans) % mod;
            else ans = (ans - temp + mod) % mod;
            add = !add;
        }
        return ans;
    }

    private static long sumupto(int i, long mod) {
        long ans = ((long) i) * (i + 1);
        ans /= 2;
        return ans % mod;
    }


//    private static long modularDiv(long x, long y, long mod) {
//        x = x % mod;
//        long inv = modInv(y, mod);
//    }
//
//    private static long modInv(long y, long mod) {
//
//    }


    static boolean[] visited;

    private static void dfs(Node[] graph, Integer integer, HashSet<Integer> x) {
        x.add(integer);
        visited[integer] = true;
        for (Node n: graph[integer].neighbours) {
            if (!visited[n.idx]) {
                dfs(graph, n.idx, x);
            }
        }
    }

    private static void makeGraph(Node[] graph, ArrayList<Integer> c, ArrayList<Integer> d) {
        for (int i = 0; i < c.size(); i++) {
            int x = c.get(i);
            int y = d.get(i);
            if (graph[x] == null) {
                graph[x] = new Node();
                graph[x].neighbours = new ArrayList<>();
                graph[x].idx = x;
            }
            if (graph[y] == null) {
                graph[y] = new Node();
                graph[y].neighbours = new ArrayList<>();
                graph[y].idx = y;
            }
            graph[x].neighbours.add(graph[y]);
            graph[y].neighbours.add(graph[x]);
        }
    }

    private static class Node {
        int idx;
        ArrayList<Node> neighbours;
    }
}
