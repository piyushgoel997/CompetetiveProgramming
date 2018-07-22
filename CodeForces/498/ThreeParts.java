import java.util.Scanner;

public class ThreeParts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = s.nextLong();
        }
        if (n <= 1) {
            System.out.println(0);
            return;
        }
        int i = -1;
        int j = n;
        long left = 0;
        long right = 0;
        long max = 0;
        while (j > i) {
            if (left == right) {
                max = left;
                i++;
                j--;
                left += d[i];
                right += d[j];
            } else if (left < right){
                i++;
                left += d[i];
            } else {
                j--;
                right += d[j];
            }
        }
        System.out.println(max);
    }
}
