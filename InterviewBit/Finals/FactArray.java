import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
923
561
230
100
399
542
198
548
892
721
781
174
809
9
232
165
861
36
837
377
313
475
269
210
530
940
570
24
434
764
275
709
325
505
161
724
47
359
625
291
81
406
465
242
767
698
408
629
86
597
358
399
72
979
962
903
919
884
627
353
1
254
414
678
111
575
755
511
287
380
802
720
138
520
314
905
670
74
886
756
671
244
508
744
224
822
347
495
706
326
201
707
580
615
386
43
543
141
554
0
*/

public class FactArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int x = 251;
        while(x!=0){
            A.add(x);
            x = s.nextInt();
        }
        System.out.println(solve(A));
        System.out.println();
    }

    public static int solve(ArrayList<Integer> A) {
        int max = 0;
        for (int i = 0; i < A.size(); i++) max = Math.max(max, A.get(i));
        boolean isPrime[] = primeSeive(max);
        int[] greatestPrime = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = A.get(i); j >= 1; j--) {
                if (isPrime[j]){
                    greatestPrime[i] = j;
                    break;
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < greatestPrime.length; i++) {
            map.putIfAbsent(greatestPrime[i], 0);
            map.put(greatestPrime[i], map.get(greatestPrime[i])+1);
        }
        long count = 0;
        for (Integer i : map.keySet()) {
            int x = map.get(i);
            count = ((count + fastExp(2, x, 1000000007))%1000000007 + 1000000007 - 1)%1000000007;
        }
        return (int) count;
        // return (int) count;
    }

    private static boolean[] primeSeive(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) for (int j = 2*i; j <= n; j += i) isPrime[j] = false;
        }
        return isPrime;
    }

    private static long fastExp(long x, long n, long mod) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans = (ans * x) % mod;
            x = (x * x) % mod;
            n /= 2;
        }
        return ans;
    }
}
