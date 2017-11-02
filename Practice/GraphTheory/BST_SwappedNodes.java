package GraphTheory;

/**
 * Created by piyus on 13-09-2017 at 16:18.
 * Two Nodes of BST are swapped, find them and correct the tree.
 */
public class BST_SwappedNodes {


    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class BST {
        Node root;

        static Node one;
        static Node two;

//        static int findSwappedNodes(Node x, int max) {
//            // inOrder traversal
//            if (x == null) return 0;
//
//
//            int left = findSwappedNodes(x.left, x.data);
//            int right = findSwappedNodes(x.right, max);
//            if (one == null && x.data > right) {
//                one = x;
//            }else if (one!=null&&x.data>m)
//        }
    }

}
