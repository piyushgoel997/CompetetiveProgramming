import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DestructionOfATree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            if (tree[i] == null) tree[i] = new Node(i);
            int y = s.nextInt();
            if (y == 0) continue;
            y--;
            if (tree[y] == null) tree[y] = new Node(y);
            tree[i].addEdge(tree[y]);
            tree[y].addEdge(tree[i]);
        }
        visited = new boolean[n];
        dfs(tree, 0);
        System.out.println(0);
    }

    private static boolean[] visited;

    private static int dfs(Node[] tree, int x) {
        if (visited[x]) return -1;
        visited[x] = true;
        int total = 0;
        for (int i = 0; i < tree[x].adj.size(); i++) {
            int temp = dfs(tree, tree[x].adj.get(i).x) + 1;
            tree[x].num.add(temp);
            total += temp;
        }
        return total;
    }

    private static class Node {
        int x;
        List<Node> adj;
        List<Integer> num;  // no. of nodes in the children's subtrees

        Node(int x) {
            this.x = x;
            this.num = new ArrayList<>();
            this.adj = new ArrayList<>();
        }

        void addEdge(Node y) {
            adj.add(y);
        }
    }

}
