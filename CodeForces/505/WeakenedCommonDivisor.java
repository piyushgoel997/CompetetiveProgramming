import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WeakenedCommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[][] pairs = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i][0] = Long.parseLong(st.nextToken());
            pairs[i][1] = Long.parseLong(st.nextToken());
        }
//        pairs[0][0] = 1999999999; //////////
//
//        for (long i = 2; i <= temp; i++) {
//            boolean possible = true;
//            for (int j = 0; j < n; j++) {
//                if (pairs[j][0] % i != 0 && pairs[j][1] != 0) {
//                    possible = false;
//                    break;
//                }
//            }
//            if (possible) {
//                System.out.println(i);
//                return;
//            }
//        }
//        System.out.println(-1);


        Set<Long> set = new HashSet<>();
        Long temp = pairs[0][0];
        for (int i = 2; i <= Math.sqrt(temp); i++) {
            while (temp % i == 0) {
                set.add((long) i);
                temp /= i;
            }
        }
        set.add(temp);
        temp = pairs[0][1];
        for (int i = 2; i <= Math.sqrt(temp); i++) {
            while (temp % i == 0) {
                set.add((long) i);
                temp /= i;
            }
        }
        set.add(temp);
        set.remove(1L);
        for (int i = 1; i < n; i++) {
            Set<Long> rm = new HashSet<>();
            for (Long l : set) {
                if (pairs[i][0] % l != 0 && pairs[i][1] % l != 0) rm.add(l);
            }
            set.removeAll(rm);
            if (set.size() == 0) {
                System.out.println(-1);
                return;
            }
        }

        for (Long l : set) {
            System.out.println(l);
            return;
        }
    }

//    private static void removeNonPrimes(Set<Long> set) {
//        Set<Long> rm = new HashSet<>();
//        for (long l : set) {
//            for (long x : set) {
//                if (x / l > 1 && x % l == 0) {
//                    rm.add(x);
//                }
//            }
//        }
//        set.removeAll(rm);
//    }
}
