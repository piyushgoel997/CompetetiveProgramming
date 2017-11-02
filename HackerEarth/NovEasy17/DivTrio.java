package NovEasy17;


import DynamicProgramming.LIS;

import java.util.*;

/**
 * Created by piyus on 01-11-2017 at 22:08.
 */
public class DivTrio {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        List<Integer>[] mod = new List[m];
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (mod[x % m] == null) {
                mod[x % m] = new ArrayList<>();
            }
            mod[x % m].add(x);
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (i + j >= m) break;
                if (i > j || j > m - i - j) continue;
                if (i == j || j == (m - i - j)%m) {
                    if (i == j && j == (m - i - j)%m) {
                        int size = mod[i].size();
                        if (size > 2) ans += factorial(3, size);
                    } else if (i == j) {
                        if (mod[i].size() > 1) ans += mod[i].size() * (mod[i].size() - 1) * mod[(m - i - j)%m].size();
                    } else {
                        if (mod[j].size() > 1) ans += mod[i].size() * mod[j].size() * (mod[j].size() - 1);
                    }
                } else {
                    ans += mod[i].size() * mod[j].size() * mod[m - i - j].size();
                }
                System.out.println(i + "," + j + "," + (m - i - j)%m);
                System.out.println(ans);
            }
        }
//        ans += factorial(3, zero.size());
        System.out.println(ans);
    }

    public static long factorial(long a, long b) {
        long fact = 1;
        for (long i = a + 1; i <= b; i++) fact = (fact * i);
        return fact;
    }
}
