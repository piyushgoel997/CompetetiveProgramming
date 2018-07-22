import java.util.Scanner;

/**
 * Created by Piyush on 31-10-2016.
 */
public class KostyaTheSculptor {  //correct but slow. need to find a better solution.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
            arr[i][2] = s.nextInt();
        }
        int maxRad = 0;
        int maxI = 0, maxJ = 0;
        for (int i = 0; i < n; i++) {
            int x = findMaxRad(arr[i]);
            if (x > maxRad) {
                maxRad = x;
                maxI = i;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] temp = checkCompatibility(arr[i], arr[j]);
                if (temp != null) {
                    int x = findMaxRad(temp);
                    if (x > maxRad) {
                        maxRad = x;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        if (maxJ == 0) {
            System.out.println(1);
            System.out.println((maxI+1));
        }else {
            System.out.println(2);
            System.out.println((maxI + 1) + " " + (maxJ + 1));
        }
    }

    private static int findMaxRad(int[] sides) {
        // equivalent to finding min of the 3
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        if (a < b) {
            if (a <= c) {
                return a;
            }
            return c;
        } else if (a > b) {
            if (b <= c) {
                return b;
            }
            return c;
        } else {
            if (a <= c) {
                return a;
            }
            return c;
        }
    }

    private static int[] checkCompatibility(int[] a, int[] b) {
        int[] B = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            B[i] = b[i];
        }
        int[] A = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            A[i] = a[i];
        }
        int[] newSides = new int[3];
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    newSides[k] = A[i];
                    B[j] = 0;
                    A[i] = -1;
                    k++;
                    break;
                }
            }
        }

        if (k == 3) {
            return newSides;
        }
        if (k == 2) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == -1) {
                    A[i] = 0;
                }
                newSides[k] += a[i] + b[i];
            }
            return newSides;
        }
        return null;
    }
}
