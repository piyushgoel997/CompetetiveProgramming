import java.util.*;

public class MilitaryProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(i + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            int x = s.nextInt();
            tree[x - 1].sub.add(i + 1);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(tree[i].sub);
        }

        int[] sorted = new int[n];
        int[] possible = new int[n];



        for (int i = 0; i < q; i++) {
            int u = s.nextInt();
            k = s.nextInt();
//            System.out.println(query(tree, u));
        }
    }

    static int k;

    private static int dfs(Node[] tree, int i) {
        if (k >= tree.length) return -1;

        for (int x : tree[i].sub) {
            int curr = dfs(tree, x);
            if (curr >= 0) {
                return curr;
            }
        }
        return -1;
    }

    private static class Node {
        int id;
        ArrayList<Integer> sub;

        public Node(int id) {
            this.id = id;
            sub = new ArrayList<>();
        }
    }


}
