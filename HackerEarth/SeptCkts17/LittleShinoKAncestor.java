package SeptCkts17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by piyus on 01-10-2017 at 14:06.
 */
public class LittleShinoKAncestor {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        if (k > n - 1) {
            for (int i = 0; i < n; i++) System.out.print(-1 + " ");
            return;
        }
        Tree t = new Tree();
        for (int i = 1; i <= n; i++) t.setColor(i, s.nextInt());
        for (int i = 0; i < n -1; i++) t.addEdge(s.nextInt(), s.nextInt());
        int[] ancestors = t.KAncestors(k);
        for (int i = 1; i <= n; i++) {
            System.out.print(ancestors[i] + " ");
//            if (ancestors[i] != 0) System.out.print(ancestors[i] + " ");
//            else System.out.print("-1 ");
        }
    }

    static class Tree {
        ArrayList<Integer>[] edgeList = new ArrayList[1000001];
        ArrayList<Integer>[] colorQueue = new ArrayList[1000001];
        int[] color = new int[1000001];
        int[] ancestor = new int[1000001];
        boolean[] visited = new boolean[1000001];

        void setColor(int i, int c) {
            color[i] = c;
            if (edgeList[i] == null) edgeList[i] = new ArrayList<>();
            if (colorQueue[c] == null) colorQueue[c] = new ArrayList<>();
        }


        void addEdge(int p, int i) {
            edgeList[p].add(i);
            edgeList[i].add(p);
        }

        int[] KAncestors(int k) {
            for (int i = 0; i < visited.length; i++) visited[i] = false;
            dfs(1,k);
            return ancestor;
        }

        private void dfs(int x, int k) {
            if (visited[x]) return;
            visited[x] = true;
            if (colorQueue[color[x]].size() >= k)
                ancestor[x] = colorQueue[color[x]].get(colorQueue[color[x]].size() - k);
            else ancestor[x] = -1;
            colorQueue[color[x]].add(x);
            for (int i : edgeList[x]) dfs(i, k);
            if (colorQueue[color[x]].size() > 0) colorQueue[color[x]].remove(colorQueue[color[x]].size() - 1);
        }
    }








//    public static void main(String args[] ) throws Exception {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int k = s.nextInt();
//        Tree t = new Tree(n);
//        for (int i = 0; i < n; i++) t.setColor(i, s.nextInt() - 1);
//        for (int i = 0; i < n -1; i++) t.setParent(s.nextInt() - 1, s.nextInt() - 1);
//        for (int i : t.KAncestors(k)) System.out.print(i + 1 + " ");
//    }
//
//    public static class Tree {
//        int[] color;
//        int[] parent;
//
//        Tree(int n) {
//            color = new int[n];
//            parent = new int[n];
//            parent[0] = -1;
//        }
//
//        void setColor(int i, int c) {
//            color[i] = c;
//        }
//
//        void setParent(int p, int ch) {
//            parent[ch] = p;
//        }
//
//        int kthAncestor(int x, int k) {
//            int ancestor = x;
//            for (int i = 0; i < k;) {
//                ancestor = parent[ancestor];
//                if (ancestor == -1) return -2;
//                if (color[ancestor] == color[x]) i++;
//            }
//            if (color[ancestor] == color[x]) return ancestor;
//            return -2;
//        }
//
//        boolean[] visited;
//        int[] KAncestors(int k) {
//            visited = new boolean[color.length];
//            ancestor = new int[visited.length];
//            for (int i = 0; i < visited.length; i++) visited[i] = false;
//            for (int c = 0; c < color.length; c++) {
//                if (c < 0 || visited[c]) continue;
//                visit(c, k);
//            }
//            return ancestor;
//        }
//
//        private void visit(final int c, int k) {
//            LinkedList<Integer> l = new LinkedList<>();
//            int an = c;
//            for (int i = 0; i < k;) {
//                if (an == -1) break;
//                if (color[an] == color[c]) {
//                    visited[an] = true;
//                    l.add(an);
//                    i++;
//                }
//                an = parent[an];
//            }
//            while (an != -1) {
//                if (color[an] == color[c]){
//                    visited[an] = true;
//                    l.add(an);
//                    ancestor[l.remove()] = an;
//                }
//                an = parent[an];
//            }
//            for (int i : l) ancestor[i] = -2;
//        }
//
//        int[] ancestor;
//
//    }
}
