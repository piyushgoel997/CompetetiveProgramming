import java.util.*;

public class Alphametic {

    public static void main(String[] args) {
        System.out.println(solveAlphametic(new Scanner(System.in).next()));
    }

    static int[][] table;

    static String solveAlphametic(String alphametic) {
        int plus = 0, equal = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < alphametic.length(); i++) {
            if (alphametic.charAt(i) == '+') plus = i;
            else if (alphametic.charAt(i) == '=') equal = i;
            else set.add(alphametic.charAt(i));
        }
        boolean possible = false;
        String result = "";
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                HashMap<Character, Integer> map = new HashMap<>();
//                for (Character c : set) {
//                    map.put(c, (i + j) % 10);
//                }
//                if (checkPossible(alphametic, map, plus, equal)) {
//                    result = makeString(alphametic, map);
//                    if (possible) return "impossible";
//                    else possible = true;
//                }
//            }
//        }



//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (i == j) continue;
//                for (int k = 0; k < 10; k++) {
//                    if (k == j) continue;
//                    for (int l = 0; l < 10; l++) {
//                        if (k == l) continue;
//                        for (int m = 0; m < 10; m++) {
//                            if (l == m) continue;
//                            for (int n = 0; n < 10; n++) {
//                                if (m == n) continue;
//                                for (int o = 0; o < 10; o++) {
//                                    if (n == o) continue;
//                                    for (int p = 0; p < 10; p++) {
//                                        if (p == o) continue;
//                                        for (int q = 0; q < 10; q++) {
//                                            if (p == q) continue;
//                                            for (int r = 0; r < 10; r++) {
//                                                if (q == r) continue;
//                                                int[] arr = {i, j, k, l, m, n, o, p, q, r};
//                                                HashMap<Character, Integer> map = new HashMap<>();
//                                                int x = 0;
//                                                for (Character c : set) {
//                                                    map.put(c, arr[x] + 1);
//                                                    x++;
//                                                }
////                                                System.out.println(x);
//                                                if (checkPossible(alphametic, map, plus, equal)) {
//                                                    System.out.println(1);
//                                                    result = makeString(alphametic, map);
//                                                    if (possible) return "impossible";
//                                                    else possible = true;
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        HashMap<Character, TreeSet<Integer>> possibilities = new HashMap<>();
//        for (Character c : set) {
//            Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//            if (c == alphametic.charAt(0) || c == alphametic.charAt(plus + 1) || c == alphametic.charAt(equal + 1)) {
//                arr[arr.length - 1] = 1;
//            }
//            possibilities.put(c, new TreeSet<>(Arrays.asList(arr)));
//        }
//        while (true) { // TODO
//            HashMap<Character, Integer> map = new HashMap<>();
//            HashSet<Integer> used = new HashSet<>();
//            for (Character c : set) {
//                for (int i = 0; i < 9; i++) {
//
//                }
//            }
//        }


        table = new int[set.size()][10];

        if (possible) {
            return result;
        } else {
            return "impossible";
        }
    }


//    private static int fn(String arev, String brev, String crev, HashMap<Character, Integer> map, int carry, int idx) {
//        if (idx >= crev.length()) return 1;
//        int a = idx >= arev.length() || map.containsKey(arev.charAt(idx))? 1 : 0;
//        int b = idx >= brev.length() || map.containsKey(brev.charAt(idx))? 1 : 0;
//        int c = map.containsKey(crev.charAt(idx)) ? 1 : 0;
//        if (a+b+c==3) {
//            int curr = map.get(arev.charAt(idx)) + map.get(brev.charAt(idx)) + carry;
//            if (curr / 10 == map.get(crev.charAt(idx))) {
//                return fn(arev, brev, crev, map, curr % 10, idx + 1);
//            }
//            return 0;
//        }
//        if (a+b+c==2) {
//            if (a == 0) {
//                return temp(arev, brev, crev, idx, map, carry);
//            } else if (b == 0) {
//                return temp(brev, arev, crev, idx, map, carry);
//            } else if (c == 0) {
//                b = idx >= brev.length() ? 0 : map.get(brev.charAt(idx));
//                a = idx >= arev.length() ? 0 : map.get(arev.charAt(idx));
//                c = a + b;
//                if (!map.containsValue(c / 10)) {
//                    map.put(crev.charAt(idx), c / 10);
//                    return fn(arev, brev, crev, map, c % 10, idx + 1);
//                } else {
//                    return 0;
//                }
//            }
//            if (a + b + c == 1) {
//                if (c == 1) {
//                    int ct = 0;
//                    for (int i = 0; i < 10; i++) {
//                        if (i == 0 && idx == arev.length()) continue;
//                        if (map.containsValue(i)) continue;
//                        map.put(arev.charAt(idx), i);
//                        ct += temp(brev, arev, crev, idx, map, carry);
//                    }
//                    return ct;
//                }
//                if (a == 1) {
//                    int ct = 0;
//                    for (int i = 0; i < 10; i++) {
//
//                    }
//                }
//            }
//        }
//    }

//    private static int temp(String arev, String brev, String crev, int idx, HashMap<Character, Integer> map, int carry) {
//        int b = idx >= brev.length()? 0 : map.get(brev.charAt(idx));
//        int c = map.get(crev.charAt(idx));
//        int ct = 0;
//        int x = c - b - carry;
//        if (!map.containsValue(x))
//            if (idx == arev.length()) {
//                if (x > 0 && x < 10) {
//                    map.put(arev.charAt(idx), x);
//                    ct += fn(arev, brev, crev, map, 0, idx + 1);
//                }
//            } else {
//                if (x >= 0 && x < 10) {
//                    map.put(arev.charAt(idx), x);
//                    ct += fn(arev, brev, crev, map, 0, idx + 1);
//                }
//            }
//        x += 10;
//        if (!map.containsValue(x))
//            if (idx == arev.length()) {
//                if (x > 0 && x < 10) {
//                    map.put(arev.charAt(idx), x);
//                    ct += fn(arev, brev, crev, map, 0, idx + 1);
//                }
//            } else {
//                if (x >= 0 && x < 10) {
//                    map.put(arev.charAt(idx), x);
//                    ct += fn(arev, brev, crev, map, 0, idx + 1);
//                }
//            }
//        x += 10;
//        if (!map.containsValue(x))
//            if (idx == arev.length()) {
//                if (x > 0 && x < 10) {
//                    map.put(arev.charAt(idx), x);
//                    ct += fn(arev, brev, crev, map, 0, idx + 1);
//                }
//            } else {
//                if (x >= 0 && x < 10) {
//                    map.put(arev.charAt(idx), x);
//                    ct += fn(arev, brev, crev, map, 0, idx + 1);
//                }
//            }
//        return ct;
//    }


    private static boolean checkPossible(String alphametic, HashMap<Character, Integer> map, int plus, int equal) {
        if (map.get(alphametic.charAt(0)) == 0 || map.get(alphametic.charAt(plus + 1)) == 0 || map.get(alphametic.charAt(equal + 1)) == 0) {
            return false;
        }
        int carry = 0;
        String a = new StringBuilder(alphametic.substring(0, plus)).reverse().toString();
        String b = new StringBuilder(alphametic.substring(plus + 1, equal)).reverse().toString();
        String c = new StringBuilder(alphametic.substring(equal + 1)).reverse().toString();
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        for (int i = 0; i < c.length(); i++) {
            int sum = carry;
            if (i < a.length()) sum += map.get(a.charAt(i));
            if (i < b.length()) sum += map.get(b.charAt(i));
            carry = sum / 10;
            if (sum % 10 != map.get(c.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String makeString(String alphametic, HashMap<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphametic.length(); i++) {
            if (alphametic.charAt(i) == '+') {
                sb.append('+');
            } else if (alphametic.charAt(i) == '=') {
                sb.append('=');
            } else {
                sb.append(map.get(alphametic.charAt(i)));
            }
        }
        return sb.toString();
    }
}
