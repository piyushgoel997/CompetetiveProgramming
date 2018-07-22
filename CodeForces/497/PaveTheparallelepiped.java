import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PaveTheparallelepiped {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            HashSet<Integer> A = factors(s.nextInt());
            HashSet<Integer> B = factors(s.nextInt());
            HashSet<Integer> C = factors(s.nextInt());
            HashSet<Integer> all = new HashSet<>(A);
            all.addAll(B);
            all.addAll(C);
            long count = 0;
            ArrayList<Integer> list = new ArrayList<>(all);

            for (int a : A) {
                for (int b : B) {
                    if (b < a && (A.contains(b) && B.contains(a))) {
                        continue;
                    }
                    for (int c : C) {
                        if (a == b && b == c) {
                            count++;
                            continue;
                        }
                        if (c <= Math.min(a, b)) {
                            if (condition(A, B, C, a, c, b) || condition(A, B, C, c, a, b) || condition(A, B, C, b, c, a) || condition(A, B, C, c, b, a)) {
                                continue;
                            }
                        }
                        ////////////
//                        System.out.print(a);
//                        System.out.print(b);
//                        System.out.print(c);
                        ////////////
                        count++;
                    }
                }
            }

//            for (int i = 0; i < list.size(); i++) {
//                for (int j = i; j < list.size(); j++) {
//                    for (int k = j; k < list.size(); k++) {
//                        if (condition(list,A, B, C, i, j, k) || condition(list, A, B, C, i, k, j) || condition(list, A, B, C, j, i, k) || condition(list, A, B, C, k, i, j) || condition(list, A, B, C, j, k, i) || condition(list, A, B, C, k, j, i)) {
//                            count++;
//                        }
//                    }
//                }
//            }
//            System.out.println();  //////////////
            System.out.println(count);
        }
    }

//    private static boolean condition(ArrayList<Integer> list, HashSet<Integer> a, HashSet<Integer> b, HashSet<Integer> c, int i, int j, int k) {
//        return a.contains(list.get(i)) && b.contains(list.get(j)) && c.contains(list.get(k));
//    }

    private static boolean condition(HashSet<Integer> a, HashSet<Integer> b, HashSet<Integer> c, int i, int j, int k) {
        return a.contains(i) && b.contains(j) && c.contains(k);
    }

    private static HashSet<Integer> factors(int i) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = 1; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                set.add(j);
                set.add(i / j);
            }
        }
        return set;
    }
}
