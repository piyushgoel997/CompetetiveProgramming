import java.util.Arrays;
import java.util.Scanner;

public class EasyProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            cost[i] = s.nextLong();
        }
        int[] idx = new int[8];
        Arrays.fill(idx, -1);
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'h':
                    if (idx[0] == -1) idx[0] = i;
                    break;
                case 'a':
                    if (idx[0] == -1) break;
                    if (idx[2] == -1) idx[2] = i;
                    break;
                case 'r':
                    if (idx[2] == -1) break;
                    if (idx[4] == -1) idx[4] = i;
                    break;
                case 'd':
                    if (idx[4] == -1) break;
                    if (idx[6] == -1) idx[6] = i;
                    break;
            }
        }


        for (int i = str.length() - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case 'h':
                    if (idx[3] == -1) break;
                    if (idx[1] == -1) idx[1] = i;
                    break;
                case 'a':
                    if (idx[5] == -1) break;
                    if (idx[3] == -1) idx[3] = i;
                    break;
                case 'r':
                    if (idx[7] == -1) break;
                    if (idx[5] == -1) idx[5] = i;
                    break;
                case 'd':
                    if (idx[7] == -1) idx[7] = i;
                    break;
            }
        }
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] == -1) {
                System.out.println(0);
                return;
            }
        }
        long[] rem = new long[4];
        for (int j = 0; j < 4; j++) {
            for (int i = idx[2 * j]; i <= idx[2 * j + 1]; i++) {
                if ((j == 0 && str.charAt(i) == 'h') || (j == 1 && str.charAt(i) == 'a') || (j == 2 && str.charAt(i) == 'r') || (j == 3 && str.charAt(i) == 'd')) {
                    rem[j] += cost[i];
                }
            }
        }
        long min = rem[0];
        for (int i = 0; i < rem.length; i++) {
            min = Math.min(min, rem[i]);
        }
        System.out.println(min);
    }
}
