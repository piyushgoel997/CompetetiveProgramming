import java.util.Scanner;

/**
 * Created by Piyush on 31-10-2016.
 */
public class Parade {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }
        int sums[] = findBeauty(arr);
        int maxBeauty = sums[0] - sums[1] > 0 ? sums[0] - sums[1] : sums[1] - sums[0];
        int j = -1;
        for (int i = 0; i < n; i++) {
            int temp = arr[i][0] - arr[i][1];
            int l = sums[0] - temp;
            int r = sums[1] + temp;
            int tempBeauty = l - r > 0 ? l - r : r - l;
            if (tempBeauty > maxBeauty) {
                maxBeauty = tempBeauty;
                j = i;
            }
        }
        if (j == -1) {
            System.out.print(0);
        }else {
            System.out.print(j+1);
        }
    }

    private static int[] findBeauty(int[][] arr) {
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            l += arr[i][0];
            r += arr[i][1];
        }

        return new int[] {l,r};
    }
}
