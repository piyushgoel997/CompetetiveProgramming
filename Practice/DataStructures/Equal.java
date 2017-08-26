package DataStructures;

import java.util.Scanner;

/**
 * Created by piyus on 21-08-2017 at 01:56.
 * HackerRank. DP - Medium. Correct.
 */
public class Equal {

    private static Scanner s;

    public static void main(String args[] ) throws Exception {
        s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(s.nextInt()));
        }
    }

    // Greedy Solution - incorrect for a few test cases eg. -
//    private static long solve(int n) {
//        int[] arr = new int[n];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            arr[i] = s.nextInt();
//            if (arr[i] < min) min = arr[i];
//        }
//        long num = 0;
//        for (int i = 0; i < n; i++) {
//            arr[i] -= min;
//            if (arr[i] > 0) {
//                num += arr[i] / 5;
//                arr[i] %= 5;
//                num += arr[i] / 2;
//                num += arr[i] % 2;
//            }
//        }
//        return num;
//    }

//    private static long solve(int n) {
//        int[] arr = new int[n];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            arr[i] = s.nextInt();
//            if (arr[i] < min) min = arr[i];
//        }
//        long num = 0;
//        for (int i = 0; i < n; i++) {
//            arr[i] -= min;
//            if (arr[i] > 0) {
//                num += arr[i] / 5;
//                arr[i] %= 5;
//                if (arr[i] > 3) arr[i] -= 5;
//                else {
//                    num += arr[i] / 2;
//                    num += arr[i] % 2;
//                    arr[i] = 0;
//                }
//            }
//        }
//
//        min = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] < min) min = arr[i];
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i] -= min;
//            num += arr[i] / 2;
//            num += arr[i] % 2;
//        }
//
//        return num;
//    }

    private static long solve(int n) {
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (arr[i] < min) min = arr[i];
        }
//        long a = 0;
//        long b = 0;

        long num = fn(arr, n, min);

        for (int i = 0; i <= 4; i++) {
            long temp = fn(arr, n, min - i);
            if (temp < num) num = temp;
        }

//        if (min>=1) {
//            long temp = fn(arr, n, min - 1);
//            if (temp < num) num = temp;
//        }
//        if (min>=2) {
//            long temp = fn(arr, n, min - 2);
//            if (temp < num) num = temp;
//        }
//        if (min>=3) {
//            long temp = fn(arr, n, min - 3);
//            if (temp < num) num = temp;
//        }
//        if (min>=4) {
//            long temp = fn(arr, n, min - 4);
//            if (temp < num) num = temp;
//        }
//        if (min>=5) {
//            long temp = fn(arr, n, min - 5);
//            if (temp < num) num = temp;
//        }

//        for (int i = 0; i < n; i++) {
//            arr[i] -= min;
//            if (arr[i] > 0) {
//                num1 += arr[i] / 5;
//                arr[i] %= 5;
//                num1 += arr[i] / 2;
//                num1 += arr[i] % 2;
////                a += arr[i] / 2;
////                a += arr[i] % 2
//            }
//        }

//        for (int i = 0; i < n; i++) {
//            if (arr[i] > 2) arr[i] -= 5;
//            else {
//                b += arr[i] / 2;
//                b += arr[i] % 2;
//                arr[i] = 0;
//            }
//        }
//
//        min = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] < min) min = arr[i];
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i] -= min;
//            b += arr[i] / 2;
//            b += arr[i] % 2;
//        }
//
//        return num + Math.min(a, b);


        return num;

    }

    private static long fn(int[] a, int n, int min) {
        int[] arr = new int[n];
        System.arraycopy(a, 0, arr, 0, n);
        long num = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            if (arr[i] > 0) {
                num += arr[i] / 5;
                arr[i] %= 5;
                num += arr[i] / 2;
                num += arr[i] % 2;
            }
        }
        return num;
    }

}
