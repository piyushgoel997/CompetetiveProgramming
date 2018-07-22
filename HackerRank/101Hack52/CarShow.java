import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 03-12-2017 at 20:56.
 * https://www.hackerrank.com/contests/101hack52/challenges/car-show/problem
 */
public class CarShow {

    private static int[] lastOccurrence;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        lastOccurrence = new int[n + 1];
        fillOccurrences(A);
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
//            System.out.println(numChoices(A, l, r));
        }
        in.close();
    }

    private static void fillOccurrences(int[] a) {
        Arrays.fill(lastOccurrence, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                lastOccurrence[i] = map.get(a[i]);
            }
            map.put(a[i], i);
        }
    }
    // https://www.hackerrank.com/rest/contests/101hack52/challenges/car-show/hackers/asgarj/download_solution
    // https://www.hackerrank.com/rest/contests/101hack52/challenges/car-show/hackers/omaryasser/download_solution

//    private static long numChoices(int[] a, int l, int r) {
//        if (table[l][r] != 0) return table[l][r];
//        long choices = 0;
//        int i = l;
//        int j = l;
//        HashMap<Integer, Integer> indices = new HashMap<>();
//        while (j <= r) {
//            if (indices.containsKey(a[j]) && indices.get(a[j]) >= i) {
//                long x = j - i;
//                int rep = indices.get(a[j]);
//                table[i][rep] = (x * (x + 1)) / 2;
//                table[i][rep] -= ((long)(j - rep - 1) * (j - rep)) / 2;
//                choices += table[i][rep];
//                i = rep + 1;
//            }
//            if (j > 1)table[i][j - 1] = ((j - i) * (j - i + 1)) / 2;
//            indices.put(a[j], j);
//            j++;
//        }
//        long x = j - i;
//        table[i][r] = (x * (x + 1)) / 2;
//        choices += table[i][r];
//        return table[l][r] = choices;
//    }

//    private static int[] longest;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int q = in.nextInt();
//        int[] A = new int[n];
//        for(int A_i = 0; A_i < n; A_i++){
//            A[A_i] = in.nextInt();
//        }
//
//
//        longest = new int[n + 1];
//        longestArrStartingWith(A, 0);
//
//        for(int a0 = 0; a0 < q; a0++){
//            int l = in.nextInt() - 1;
//            int r = in.nextInt() - 1;
//            int ans = longest[l];
//            if (ans > r - l) System.out.println(r - l);
//            else System.out.println(ans);
//        }
//        in.close();
//    }
//
//    private static HashMap<Integer, Integer> longestArrStartingWith(int[] a, int i) {
//        if (i == a.length - 1) {
//            HashMap<Integer, Integer> hm = new HashMap();
//            hm.put(a[i], i);
//            longest[i] = 1;
//            return hm;
//        }
//        HashMap<Integer, Integer> map = longestArrStartingWith(a, i + 1);
//        if (!map.containsKey(a[i])) {
//            longest[i] = longest[i + 1] + 1;
//            map.put(a[i], i);
//            return map;
//        } else {
//            int j = map.get(a[i]);
//            map = new HashMap<>();
//            for (int k = i; k < j; k++) {
//                map.put(a[k], k);
//            }
//            longest[i] = j - i;
//            return map;
//        }
//    }

}
