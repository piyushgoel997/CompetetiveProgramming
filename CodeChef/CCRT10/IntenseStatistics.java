package CCRT10;
import java.io.*;
import java.util.StringTokenizer;

public class IntenseStatistics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            sumSegTree = new long[4 * arr.length];
            constructSumSegTree(arr, 0, arr.length - 1, 0);

            maxSegTree = new long[4 * arr.length];
            constructMaxSegTree(arr, 0, arr.length - 1, 0);

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) {
                    int l = Integer.parseInt(st.nextToken()) - 1;
                    int r = Integer.parseInt(st.nextToken()) - 1;
                    log.write("" + (getSum(0, arr.length - 1, l, r, 0) - getMax(0, arr.length - 1, l, r, 0)));
                    log.write("\n");
                } else {
                    int k = Integer.parseInt(st.nextToken()) - 1;
                    long val = Integer.parseInt(st.nextToken());
                    updateValue(arr, k, val);
                    arr[k] = val;
                    updateValue2(0, arr.length - 1, k, val, 0);
                }
            }
        }
        log.flush();
    }

    private static long[] sumSegTree;

    private static long constructSumSegTree(long[] arr, int start, int end, int i) {
        if (start == end) return sumSegTree[i] = arr[start];
        int mid = (start + end) / 2;
        return sumSegTree[i] = constructSumSegTree(arr, start, mid, 2 * i + 1) + constructSumSegTree(arr, mid + 1, end, 2 * i + 2);
    }

    private static long getSum(int start, int end, int qstart, int qend, int i) {
        if (qstart <= start && qend >= end) return sumSegTree[i];
        if (end < qstart || start > qend) return 0;
        int mid = (start + end) / 2;
        return getSum(start, mid, qstart, qend, 2 * i + 1) + getSum(mid + 1, end, qstart, qend, 2 * i + 2);
    }


    private static void updateValueUtil(int start, int end, int qi, long diff, int i) {
        if (qi < start || qi > end) return;

        sumSegTree[i] = sumSegTree[i] + diff;
        if (end != start) {
            int mid = (start + end) / 2;
            updateValueUtil(start, mid, qi, diff, 2 * i + 1);
            updateValueUtil(mid + 1, end, qi, diff, 2 * i + 2);
        }
    }

    private static void updateValue(long[] arr, int i, long newVal) {
        long diff = newVal - arr[i];
        arr[i] = newVal;
        updateValueUtil(0, arr.length - 1, i, diff, 0);
    }


    private static long[] maxSegTree;

    private static long constructMaxSegTree(long[] arr, int start, int end, int i) {
        if (start == end) return maxSegTree[i] = arr[start];
        int mid = (start + end) / 2;
        return maxSegTree[i] = Math.max(constructMaxSegTree(arr, start, mid, 2 * i + 1), constructMaxSegTree(arr, mid + 1, end, 2 * i + 2));
    }

    private static long getMax(int start, int end, int qstart, int qend, int i) {
        if (qstart <= start && qend >= end) return maxSegTree[i];
        if (end < qstart || start > qend) return Long.MIN_VALUE;
        int mid = (start + end) / 2;
        return Math.max(getMax(start, mid, qstart, qend, 2 * i + 1), getMax(mid + 1, end, qstart, qend, 2 * i + 2));
    }

    private static void updateValue2(int start, int end, int qi, long newVal, int i) {
        if (qi < start || qi > end) return;
        if (start == end) maxSegTree[i] = newVal;
        else {
            int mid = (start + end) / 2;
            if (qi >= start && qi <= mid) updateValue2(start, mid, qi, newVal, 2 * i + 1);
            else updateValue2(mid + 1, end, qi, newVal, 2 * i + 2);
            maxSegTree[i] = Math.max(maxSegTree[2 * i + 1], maxSegTree[2 * i + 2]);
        }
    }

}
