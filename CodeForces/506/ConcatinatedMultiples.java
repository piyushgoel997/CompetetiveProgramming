import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ConcatinatedMultiples {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        int[] len = new int[n];

        long[] zeros = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            for (int j = 1; j < 10; j++) {
                if (a[i] / zeros[j] == 0) {
                    len[i] = j;
                    break;
                }
            }
        }

        HashMap<Long, Long>[] pows = new HashMap[10];
        for (int i = 0; i < 10; i++) pows[i] = new HashMap();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                long rem = (a[i] * zeros[j]) % k;
                pows[j].putIfAbsent(rem, 0L);
                pows[j].put(rem, pows[j].get(rem) + 1);
            }
        }

        long count = 0;

        for (int i = 0; i < n; i++) {
            long search = (k - (a[i] % k)) % k;
            long temp = pows[len[i]].getOrDefault(search, 0L);
            if (temp > 0 && (a[i] * zeros[len[i]]) % k == search) temp--;
            count += temp;
        }
        System.out.println(count);
    }
}
