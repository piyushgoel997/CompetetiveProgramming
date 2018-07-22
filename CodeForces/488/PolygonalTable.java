import java.util.*;

public class PolygonalTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        long[] powers = new long[n];
        Map<Long, Long> coins = new HashMap<>();
        for (int i = 0; i < n; i++) powers[i] = s.nextLong();
        for (int i = 0; i < n; i++) coins.put(powers[i], s.nextLong());

        if (k == 0) {

            for (int i = 0; i < n; i++) {
                System.out.print(coins.get(powers[i]) + " ");
            }

            return;
        }

        long[] original = Arrays.copyOf(powers, n);
        Arrays.sort(powers);
        PriorityQueue<Long> topK = new PriorityQueue<>();
        long sum = 0;
        Map<Long, Long> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long curr = coins.get(powers[i]);
            ans.put(powers[i], sum + curr);
            if (i < k) {
                topK.add(curr);
                sum += curr;
            } else {
                if (topK.peek() < curr) {
                    sum -= topK.poll();
                    topK.add(curr);
                    sum += curr;
                }
            }
        }

        for (int i = 0; i < n; i++) System.out.print(ans.get(original[i]) + " ");

    }
}
