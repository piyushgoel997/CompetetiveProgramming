import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ProductOfThree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        Arrays.sort(a);
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int i = 0; i < n; i++) {
            occ.putIfAbsent(a[i], 0);
            occ.put(a[i], occ.get(a[i]) + 1);
        }
        ArrayList<Integer> list = remDup(a);
        int ct = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            int j = i;
            int k = list.size() - 1;
            while (j <= k) {
                int pdt = list.get(i) * list.get(j) * list.get(k);
                if (pdt > x) {
                    k--;
                } else if (pdt < x) {
                    j++;
                } else {
                    k--;
                    j++;
                    if (!list.get(i).equals(list.get(j)) && !list.get(i).equals(list.get(k))) {
                        ct += occ.get(list.get(i)) * occ.get(list.get(j)) * occ.get(list.get(k));
                    } else if (list.get(i).equals(list.get(j)) && !list.get(i).equals(list.get(k))) {
                        ct += occ.get(list.get(i)) * (occ.get(list.get(j)) - 1) * occ.get(list.get(k));
                    } else if (list.get(i).equals(list.get(k)) && !list.get(i).equals(list.get(j))) {
                        ct += occ.get(list.get(i)) * (occ.get(list.get(k)) - 1) * occ.get(list.get(j));
                    } else if (list.get(k).equals(list.get(j)) && !list.get(i).equals(list.get(k))) {
                        ct += occ.get(list.get(i)) * (occ.get(list.get(j)) - 1) * occ.get(list.get(k));
                    } else if (list.get(i).equals(list.get(j)) && list.get(i).equals(list.get(k))) {
                        ct += Math.max(occ.get(list.get(i)) * (occ.get(list.get(j)) - 1) * occ.get(list.get(k) - 2), 0);
                    }
                }
            }
        }
        System.out.println(ct);
    }

    private static ArrayList<Integer> remDup(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != list.get(list.size() - 1)) {
                list.add(a[i]);
            }
        }
        return list;
    }
}
