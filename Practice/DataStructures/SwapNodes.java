package DataStructures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by piyus on 15-08-2017 at 22:53.
 * HackerRank. Trees - Medium.
 */
public class SwapNodes {

    private static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node root = new Node();
        root.data = 1;

        // taking input

        Stack<Node> one = new Stack<>();
        Stack<Node> two = new Stack<>();

        one.push(root);

        int i = 0;
        while (!one.isEmpty() || i < n) {

            while (!one.isEmpty()) {
                Node curr = one.pop();
                two.push(curr);
            }

            while (!two.isEmpty()) {
                int left = s.nextInt();
                int right = s.nextInt();

                Node curr = two.pop();

                if (left != -1) {
                    curr.left = new Node();
                    curr.left.data = left;
                    one.push(curr.left);
                } else{
                    curr.left = null;
                }

                if (right != -1) {
                    curr.right = new Node();
                    curr.right.data = right;
                    one.push(curr.right);
                } else {
                    curr.right = null;
                }

                i++;
            }
        }

        // processing

        int T = s.nextInt();
        for (int j = 0; j < T; j++) {
            swap(root, 0, s.nextInt());
            inOrderTraversal(root);
            System.out.println();
        }
    }

    private static void inOrderTraversal(Node x) {
        if (x == null) {
            return;
        }
        inOrderTraversal(x.left);
        System.out.print(x.data + " ");
        inOrderTraversal(x.right);
    }


    private static Node swap(Node x, int k, int K) {
        if (x == null) {
            return x;
        }
        if (k % K == K - 1) {
            Node temp = x.left;
            x.left = x.right;
            x.right = temp;

        }
        x.left = swap(x.left, k + 1, K);
        x.right = swap(x.right, k + 1, K);
        return x;
    }

}
