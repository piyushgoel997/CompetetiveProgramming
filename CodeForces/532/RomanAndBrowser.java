import java.util.Scanner;

public class RomanAndBrowser {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] tabs = new int[n];
        for (int i = 0; i < n; i++) tabs[i] = s.nextInt();
        int total = 0;
        for (int i = 0; i < n; i++) total += tabs[i];
        int max = 0;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = i; j < n; j += k) {
                sum += tabs[j];
            }
            max = Math.max(max, Math.abs(total - sum));
        }
        System.out.println(max);
    }
}
