import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Stringoholics {

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("a");
        A.add("ababa");
        A.add("aba");
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<String> A) {
        HashSet<Integer>[] sets = new HashSet[A.size()];
        int max_len = 0;
        for (int i = 0; i < A.size(); i++) {
            max_len = Math.max(max_len, A.get(i).length());
        }
        System.out.println(max_len);
        for (int i = 0; i < A.size(); i++) {
            sets[i] = possibilities(A.get(i), max_len);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.size(); i++) {
            for (Integer x : sets[i]) {
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }
        int time = 0;
        int max = 0;
        for (Integer x : map.keySet()) {
            int curr = map.get(x);
            if (curr > max) {
                max = curr;
                time = x;
            }
        }
        return time;
    }

    private static HashSet<Integer> possibilities(String s, int max_len) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (same(s, i)) {
                set.add(i);
            }
        }
        return set;
    }

    private static boolean same(String s, int curr) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt((curr + i) % s.length())) {
                return false;
            }
        }
        return true;
    }
}
