package DecEasy17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by piyus on 01-12-2017 at 23:49.
 */
public class PopulationOutburst {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node root = new Node(0, s.nextInt(), 0);

        // bfs - make tree
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        for (int j = 0; j < n; j++) {
            Node x = queue.poll();
            for (int i = 0; i < x.children.length; i++) {
                long id = s.nextLong();
                int size = s.nextInt();
                if (size > n - j) {
                    size = n - j;
                }
                x.children[i] = new Node(id, size, x.level + 1);
                if (queue.size() < n) queue.offer(x.children[i]);
            }
        }

        // bfs - print
        queue = new LinkedList<>();
        queue.offer(root);
        for (int j = 0; j < n; j++) {
            Node x = queue.poll();
            for (int i = 0; i < x.children.length; i++) {
                System.out.println(x.id + " " + x.children[i].level + " " + (i + 1));
                if (queue.size() < n) queue.offer(x.children[i]);
            }
        }
    }

    static class Node {
        long id;
        Node[] children;
        int level;

        public Node(long id, int n, int level) {
            this.id = id;
            children = new Node[n];
            this.level = level;
        }
    }
}
