import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximalIntersection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] left = new long[n];
        long[] right = new long[n];
//        long maxRight = 0;
//        long minLeft = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            left[i] = Long.parseLong(st.nextToken());
            right[i] = Long.parseLong(st.nextToken());
//            maxRight = Math.max(maxRight, right[i]);
//            minLeft = Math.min(minLeft, left[i]);
        }

        int[] idx = new int[2];

        for (int i = 0; i < n; i++) {
            if (left[i] > left[idx[0]]) {
                idx[0] = i;
            } else if (left[i] == left[idx[0]]) {
                if (right[i] < right[idx[0]]) {
                    idx[0] = i;
                }
            }

            if (right[i] < right[idx[1]]) {
                idx[1] = i;
            } else if (right[i] == right[idx[1]]) {
                if (left[i] > left[idx[1]]) {
                    idx[1] = i;
                }
            }
        }

        long maxLen = 0;
//        System.out.println(maxLen);
        long maxLeft = 0;
        long minRight = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == idx[0]) continue;
            maxLeft = Math.max(maxLeft, left[i]);
            minRight = Math.min(minRight, right[i]);
        }
        maxLen = Math.max(maxLen, minRight - maxLeft);
//        System.out.println(idx[0]);
//        System.out.println(maxLeft);
//        System.out.println(minRight);
//        System.out.println(maxLen);

        maxLeft = 0;
        minRight = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == idx[1]) continue;
            maxLeft = Math.max(maxLeft, left[i]);
            minRight = Math.min(minRight, right[i]);
        }
        maxLen = Math.max(maxLen, minRight - maxLeft);
//        System.out.println();
//        System.out.println(idx[1]);
//        System.out.println(maxLeft);
//        System.out.println(minRight);
        System.out.println(maxLen);
    }
}
