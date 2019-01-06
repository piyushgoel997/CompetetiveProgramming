import java.util.ArrayList;

public class LongestSubArrDiff {

    public static void main(String[] args) {
        int[] x = {96, 11, 35,23,77,60,75,71,15,91,43,4,54,60,35,84,84,35,17,8,75,14,70,81,42,82,36,33,46,51,90,50,12,15,21,30,16,46,42,68,41,31,23,1,87,94,80,41};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            A.add(x[i]);
        }
        System.out.println(solve(A,36));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = 0;
        int len = 1;
        int max = A.get(0);
        int min = A.get(0);

        maxSeg = new int[4 * A.size() + 2];
        maxSegTree(A, 1,0, A.size() - 1);
        minSeg = new int[4 * A.size() + 2];
        minSegTree(A, 1, 0, A.size() - 1);

        System.out.println();
        while (true) {

            if (max - min >= B) {
                i++;
                max = getMax(1, 0, A.size() - 1, i, j);
                min = getMin(1, 0, A.size() - 1, i, j);
            } else {
                len = Math.max(len, j - i + 1);
                j++;
                if (j >= A.size()) {
                    break;
                }
                max = Math.max(max, A.get(j));
                min = Math.min(min, A.get(j));
            }
        }
        return len;
    }

    private static int getMax(int idx, int start, int end, int i, int j) {
        if (i > end || j < start) return 0;
        if (start >= i && end <= j) return maxSeg[idx];
        return Math.max(getMax(2 * idx, start, (start + end) / 2, i, j), getMax(2 * idx + 1, 1 + (start + end) / 2, end, i, j));
    }

    private static int getMin(int idx, int start, int end, int i, int j) {
        if (i > end || j < start) return Integer.MAX_VALUE;
        if (start >= i && end <= j) return minSeg[idx];
        return Math.min(getMin(2 * idx, start, (start + end) / 2, i, j), getMin(2 * idx + 1, 1 + (start + end) / 2, end, i, j));
    }

    private static int maxSegTree(ArrayList<Integer> a, int idx, int i, int j) {
//        System.out.println(idx+" "+i+" "+j);
//        if (i > j) return Integer.MIN_VALUE;
        if (i == j) {
            return maxSeg[idx] = a.get(i);
        }
        return maxSeg[idx] = Math.max(maxSegTree(a, 2 * idx, i, (j + i) / 2), maxSegTree(a, 2 * idx + 1, 1+(j + i) / 2, j));
    }

    private static int minSegTree(ArrayList<Integer> a, int idx, int i, int j) {
        if (i >= j) {
            return minSeg[idx] = a.get(i);
        }
        return minSeg[idx] = Math.min(minSegTree(a, 2 * idx, i, (j + i) / 2), minSegTree(a, 2 * idx + 1, 1 + (j + i) / 2, j));
    }

    static int[] maxSeg;
    static int[] minSeg;
}
