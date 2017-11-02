package OctCkts17;

import java.util.*;

/**
 * Created by piyus on 28-10-2017 at 18:08.
 * TODO better solution required
 */
public class Replace {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        Set<Integer>[] indices = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = s.nextInt();
            if (indices[x] == null) indices[x] = new HashSet<>();
            indices[x].add(i);
        }
        for (int i = 0; i < q; i++) {
            int query = s.nextInt();
            if (query == 1) {
                one(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), indices);
            } else {
                System.out.println(two(s.nextInt(), s.nextInt(), s.nextInt(), indices));
            }
        }
    }

    private static void one(int a, int b, int x, int y, Set<Integer>[] indices) {
        if (indices[x] == null) return;
        if (x == y) return;
        for (Iterator<Integer> it = indices[x].iterator(); it.hasNext();) {
            int i = it.next();
            if (i >= a && i <= b) {
                if (indices[y] == null) indices[y] = new HashSet<>();
                indices[y].add(i);
                it.remove();
            }
        }
        if (indices[x].size() == 0) indices[x] = null;
    }

    private static int two(int a, int b, int x, Set<Integer>[] indices) {
        int count = 0;
        if (indices[x] == null) return 0;
        for (int i : indices[x]) {
            if (i >= a && i <= b) count++;
        }
        return count;
    }


//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int q = s.nextInt();
//        HashMap<Integer, Set<Integer>> index = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int x = s.nextInt();
//            if (!index.containsKey(x)) index.put(x, new HashSet<>());
//            index.get(x).add(i);
//        }
//        for (int i = 0; i < q; i++) {
//            if (s.nextInt() == 1) {
//                one(s.nextInt() - 1, s.nextInt() - 1, s.nextInt(), s.nextInt(), index);
//            } else {
//                System.out.println(two(s.nextInt() - 1, s.nextInt() - 1, s.nextInt(), index));
//            }
//        }
//    }
//
//    private static int two(int a, int b, int x, HashMap<Integer, Set<Integer>> index) {
//        int count = 0;
//        for (Integer i : index.get(x)) {
//            int idx = i;
//            if (idx >= a && idx <= b) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private static void one(int a, int b, int x, int y, HashMap<Integer, Set<Integer>> index) {
//        if (x == y) return;
//        if (!index.containsKey(x)) return;
//        for (Iterator<Integer> it = index.get(x).iterator(); it.hasNext(); ) {
//            int idx = it.next();
//            if (idx >= a && idx <= b) {
//                if (!index.containsKey(y)) index.put(y, new HashSet<>());
//                index.get(y).add(idx);
//                it.remove();
//            }
//        }
//        if (index.get(x).isEmpty()) index.remove(x);
//    }
}

/*
4
5
3 2 2 2
1 2 4 2 5
 */