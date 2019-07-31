import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ExamInBerSU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) times[i] = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        long curr = 0;
        long oc = 0;

        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> temp = new PriorityQueue<>(maxPQ);
            long ct = curr;
            int count = 0;
            while (ct + times[i] > M) {
                ct -= temp.remove();
                count++;
            }
            curr += times[i];
            maxPQ.add(times[i]);
            log.write((oc + count) + " ");
            while (curr > M) {
                curr -= maxPQ.remove();
                oc++;
            }
        }
        log.flush();
    }
}
