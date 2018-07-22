package DynamicProgramming;

/**
 * Created by piyus on 13-09-2017 at 15:57.
 * DP. Find a SubArray with max product.
 */
public class MaxPdtSubArray {
    public static void main(String[] args) {
        int[] a = {6, -3, -10, 0, 2};
        int[] b = {-1, -3, -10, 0, 60};
        int[] c = {-2, -3, 0, -2, -40};
        System.out.println(maxPdt(a));
        System.out.println(maxPdt(b));
        System.out.println(maxPdt(c));
    }

    private static long maxPdt(int[] a) {
        long maxPdt = 0;
        long currMaxNegative = 0;
        long currMax = 0;
        for (int i : a) {
            if (i < 0) {
                long tcm = currMax;
                long tcmn = currMaxNegative;
                currMax = tcmn * i;
                currMaxNegative = Math.min(i, tcm * i);
            } else {
                currMax = Math.max(i, currMax * i);
                currMaxNegative *= i;
            }
            maxPdt = Math.max(currMax, maxPdt);
        }
        return maxPdt;
    }
}
