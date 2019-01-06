import java.util.Scanner;

public class PowersOfTwo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        if (k > n) {
            System.out.println("NO");
            return;
        }
        int[] bin = new int[200009];
        int ct = 0;
        int temp = n;
        int i = 0;
        while (temp > 0) {
            bin[i] = temp % 2;
            ct += bin[i];
            temp /= 2;
            i++;
        }
        for (; i > 0; i--) {
            if (ct >= k) break;
            if (ct + bin[i] > k) {
                bin[i - 1] += 2 * (k - ct);
                bin[i] -= k - ct;
                ct = k;
            } else {
                bin[i - 1] += 2 * bin[i];
                ct += bin[i];
                bin[i] = 0;
            }
        }
        if (ct > k) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        for (int j = 0; j < bin.length; j++) {
            for (int l = 0; l < bin[j]; l++) {
                System.out.print((int)Math.pow(2, j));
                System.out.print(" ");
            }
        }
    }
}
