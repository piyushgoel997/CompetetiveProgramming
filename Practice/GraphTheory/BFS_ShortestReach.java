package GraphTheory;

import java.util.*;

/**
 * Created by piyus on 30-08-2017 at 16:12.
 */
public class BFS_ShortestReach {

    private static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            adjacencyList = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                adjacencyList[u].add(v);
                adjacencyList[v].add(u);
            }
            int s = in.nextInt();
            int[] shortestPaths = bfsPath(adjacencyList, s);
            for (int shortestPath : shortestPaths) if (shortestPath != 0) System.out.print(shortestPath + " ");
            System.out.println();
        }
        in.close();
    }

    private static int[] bfsPath(ArrayList<Integer>[] adjacencyList, int s) {
        int[] sp = new int[adjacencyList.length];
        for (int i = 1; i < sp.length; i++) sp[i] = -1;
        sp[s] = 0;
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int x : adjacencyList[v]) {
                if (sp[x] == -1) {
                    sp[x] = sp[v] + 6;
                    q.enqueue(x);
                }
            }
        }
        return sp;
    }

    public static class Queue<Item> implements Iterable {

        // first element of the queue
        private Node<Item> first;
        private int size;

        private class Node<T> {
            T data;
            Node<T> next;

            public Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }
        }

        public Queue(){
            first = null;
            size = 0;
        }

        // enqueues the element to the end of the queue.
        public void enqueue(Item data) {
            size++;
            if (first == null) {
                first = new Node<>(data, null);
                return;
            }
            Node<Item> curr = first;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<>(data, null);
        }

        // return the firsts element from the queue and removes it from the queue.
        public Item dequeue() {
            size--;
            Item temp = first.data;
            first = first.next;
            return temp;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public Item peek() {
            return first.data;
        }

        @Override
        public Iterator iterator() {
            return new QueueIterator();
        }

        private class QueueIterator implements Iterator {
            Node<Item> curr = first;
            @Override
            public boolean hasNext() {
                return curr.next != null;
            }

            @Override
            public Object next() {
                return (curr = curr.next);
            }
        }
    }
}
