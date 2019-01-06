import java.util.Scanner;

public class PetyaAndArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long t = s.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextLong();
        }
        long[] minPossible = new long[n + 1];
        minPossible[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            minPossible[i] = Math.min(a[i], minPossible[i + 1] + a[i]);
        }
//        minPossible[n] = 300000000000000L;
        int i = 0;
        int j = 0;
        long curr = a[0];
        int count = 0;
        while (i < n) {
            if (curr < t) count++;
            if (j >= n-1) {
                j = ++i;
                if (i >= n) break;
                curr = a[j];
            } else if (curr + minPossible[j+1] < t) {
                    j++;
                    if (j >= n) {
                        i++;
                        j = i;
                        curr = 0;
                    }
                    curr += a[j];
                } else {
                    curr -= a[i];
                    i++;
                    if (j < i) {
                        j = i;
                        if (j >= n) break;
                        curr = a[j];
                    }
                }
            }
        while (i < n) {
            if (curr < t) count++;
            curr -= a[i];
            i++;
        }
        System.out.println(count);
    }

}
