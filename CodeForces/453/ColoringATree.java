import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by piyus on 19-12-2017 at 21:29.
 */
public class ColoringATree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Node[] tree = new Node[n + 1];

        for (int i = 1; i < n + 1; i++) {
            tree[i] = new Node();
            tree[i].children = new ArrayList<>();
        }

        for (int i = 2; i < n + 1; i++) {
            int j = s.nextInt();
            tree[Math.min(i, j)].children.add(Math.max(i, j));
        }

        int[] colors = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            colors[i] = s.nextInt();
        }

        tree[1].color = colors[1];

        int count = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int c : tree[curr].children) {
                if (colors[c] != tree[curr].color) {
                    count++;
                }
                tree[c].color = colors[c];
                q.add(c);
            }
        }
        System.out.println(count);
    }

    private static class Node {
        int color;
        ArrayList<Integer> children;
    }

}
