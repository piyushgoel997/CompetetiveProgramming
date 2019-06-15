import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Cryptopangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            BigInteger[] bi = new BigInteger[n];
            for (int i = 0; i < n; i++) bi[i] = new BigInteger(st.nextToken());
            BigInteger[] nos = new BigInteger[n + 1];
            HashSet<BigInteger> set = new HashSet<>();
            int k = 0;
            while (bi[k].equals(bi[k + 1])) k++;
            nos[k + 1] = bi[k].gcd(bi[k + 1]);
            set.add(nos[k + 1]);
            for (int i = k + 1; i < n; i++) {
                nos[i + 1] = bi[i].divide(nos[i]);
                set.add(nos[i + 1]);
            }
            for (int i = k; i >= 0; i--) {
                nos[i] = bi[i].divide(nos[i + 1]);
                set.add(nos[i]);
            }
//            nos[1] = bi[0].gcd(bi[1]);
//            nos[0] = bi[0].divide(nos[1]);
//            HashSet<BigInteger> set = new HashSet<>();
//            set.add(nos[0]);
//            set.add(nos[1]);
//            for (int i = 1; i < n; i++) {
//                nos[i + 1] = bi[i].divide(nos[i]);
//                set.add(nos[i + 1]);
//            }
            ArrayList<BigInteger> list = new ArrayList<>(set);
            Collections.sort(list);
            HashMap<BigInteger, Character> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) map.put(list.get(i), (char) ('A' + i));
            System.out.print("Case #" + (t + 1) + ": ");
            for (int i = 0; i < nos.length; i++) {
                System.out.print(map.get(nos[i]));
            }
            System.out.println();
        }
    }
}
