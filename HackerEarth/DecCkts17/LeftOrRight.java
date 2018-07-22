package DecCkts17;

import java.util.*;

/**
 * Created by piyus on 15-12-2017 at 21:37.
 */
public class LeftOrRight {
    public static void main(String[] args) {
//        System.out.println(-Arrays.binarySearch(new int[]{1, 2, 3, 5, 6}, 4) - 1);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int Q = s.nextInt();
        HashMap<Integer, List<Integer>> typeToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int type = s.nextInt();
            if (!typeToId.containsKey(type)) {
                typeToId.put(type, new ArrayList<>());
            }
            List<Integer> l = typeToId.get(type);
            l.add(i);
            typeToId.put(type, l);
        }
//        for (int i : typeToId.keySet()) {
//            List<Integer> l = typeToId.get(i);
//            Collections.sort(l);
//        }
        for (int q = 0; q < Q; q++) {
            System.out.println(query(n, typeToId, s.nextInt(), s.nextInt(), s.next().charAt(0)));
        }
    }


    private static int query(int n, HashMap<Integer, List<Integer>> typeToId, int startIdx, int endType, char dir) {
        if (!typeToId.containsKey(endType)) {
            return -1;
        }
        int idx = Collections.binarySearch(typeToId.get(endType), startIdx);
        if (idx >= 0) return 0;
        if (dir == 'R') {
            idx = -idx - 1;
            if (idx < typeToId.get(endType).size()) return Math.abs(typeToId.get(endType).get(idx) - startIdx);
            else return n - Math.abs(typeToId.get(endType).get(0) - startIdx);
        }else {
            idx = -idx - 2;
            if (idx >= 0) return Math.abs(startIdx - typeToId.get(endType).get(idx));
            else return n - Math.abs(startIdx - typeToId.get(endType).get(typeToId.get(endType).size() - 1));
        }
    }

//    private static int query(int n, HashMap<Integer, List<Integer>> typeToId, int startIdx, int endType, char dir) {
//        if (!typeToId.containsKey(endType)) {
//            return -1;
//        }
//        if (dir == 'R') {
//            int min = Integer.MAX_VALUE;
//            int minG = Integer.MAX_VALUE;
//            for (int idx : typeToId.get(endType)) {
//                min = Math.min(min, idx);
//                if (idx >= startIdx) minG = Math.min(minG, idx);
//            }
//            if (minG < Integer.MAX_VALUE) return minG - startIdx;
//            else return n - startIdx + min;
//        } else {
//            int max = Integer.MIN_VALUE;
//            int maxL = Integer.MIN_VALUE;
//            for (int idx : typeToId.get(endType)) {
//                max = Math.max(max, idx);
//                if (idx <= startIdx) maxL = Math.max(maxL, idx);
//            }
//            if (maxL > Integer.MIN_VALUE) return startIdx - maxL;
//            else return n - max + startIdx;
//        }
//    }



}
