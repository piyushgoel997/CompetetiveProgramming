package GraphTheory;

/**
 * Created by piyus on 12-09-2017 at 23:19.
 * Connect Nodes at the same level in a tree.
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 */
public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {
        // simple test case
        Tree t = new Tree();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);
        t.root.right.right = new Node(6);
        t.connectNodesAtSameLevel();
        System.out.println();
    }


    private static class Node {
        int data;
        Node left;
        Node right;
        Node next;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static class Tree {


        private Node root;

        // By level order traversal in O(n) -> after connecting an upper level.
        public void connectNodesAtSameLevel() {
            Node temp = root;
            while (temp.left == null || temp.right == null) {
                if (temp.left == null) {
                    temp = temp.right;
                } else if (temp.right == null) {
                    temp = temp.left;
                }
            }
            if (temp.left == null || temp.right == null) return;
            temp.left.next = temp.right;
            while (temp != null) {
                Node l = temp;
                nextWithChildren(l);
                Node left = null;
                while (l != null) {
                    if (l.left != null && l.right != null) {
                        if (left != null) left.next = l.left;
                        l.left.next = l.right;
                        left = l.right;
                    } else {
                        if (l.left != null) {
                            left.next = l.next;
                            left = l.left;
                        } else {
                            left.next = l.next;
                            left = l.right;
                        }
                    }
                    l = l.next;
                    nextWithChildren(l);
                    if (l == null && left != null) left.next = null;
                }
                temp = nextLevel(temp, 0);
            }
        }

        // returns l if has children else a node with children in the same level
        private void nextWithChildren(Node l) {
            if (l == null) return;
            while (l.left != null || l.right != null) {
                l = l.next;
                if (l == null) return ;
            }
        }

        private Node nextLevel(Node x, int i) {
            if (x == null) return null;
            if (x.left != null) {
                if (i == 0) return x.left;
                i--;
            }
            if (x.right != null) {
                if (i == 0) return x.right;
                i--;
            }
            return nextLevel(x.next, i);
        }
    }
}
