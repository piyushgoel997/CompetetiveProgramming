import java.util.Scanner;

public class PermutationGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        winner = new int[2][n];
        dp(a, 0, true);
        for (int i = 0; i < n; i++) {
//            if (winner[0][i] == 0) {
//                dp(a, i, true);
//            }
            if (dp(a,i,true) == 1) {
                System.out.print("A");
            } else {
                System.out.print("B");
            }
        }
    }

    private static int dp(int[] a, int i, boolean alice) {
        if (alice && winner[0][i] != 0) return winner[0][i];
        else if (!alice && winner[1][i] != 0) return winner[1][i];
        int j = i;
        while (j >= 0) j -= a[i];
        j += a[i];
        for (; j < a.length; j += a[i]) {
            if (i != j && a[j] > a[i]) {
                if (alice) {
                    winner[0][i] = dp(a, j, !alice);
                    if (winner[0][i] == 1) {
                        return 1;
                    }
                } else {
                    winner[1][i] = dp(a, j, !alice);
                    if (winner[1][i] == -1) {
                        return -1;
                    }
                }
            }
        }
        if (alice && winner[0][i] == 0) winner[0][i] = -1;
        if (!alice && winner[1][i] == 0) winner[1][i] = 1;
        if (alice) return winner[0][i];
        else return winner[1][i];
    }


//    private static int dp(int[] a, int i, boolean alice) {
//        if (winner[i] != 0) {
//            if (alice == turn[i]) return winner[i];
//            else return -winner[i];
//        }
//
//        if (alice) turn[i] = true;
//        else turn[i] = false;
//
//        for (int j = 0; j < a.length; j++) {
//            if (i != j && Math.abs(i - j) % a[i] == 0) {
//                winner[i] = dp(a, j, !alice);
//            }
//            if ((winner[i] == 1 && alice) || (winner[i] == -1 && !alice)) {
//                return winner[i];
//            }
//        }
//        if (alice) return winner[i] = -1;
//        else return winner[i] = 1;
//    }

    private static int[][] winner;
}
