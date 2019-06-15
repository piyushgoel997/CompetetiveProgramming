import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StockArbitraging {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int r = s.nextInt();
        int[] buy = new int[n];
        for (int i = 0; i < n; i++) buy[i] = s.nextInt();
        Integer[] sell = new Integer[m];
        for (int i = 0; i < m; i++) sell[i] = s.nextInt();
        Arrays.sort(buy);
        Arrays.sort(sell, Collections.reverseOrder());
        if (buy[0] < sell[0]) {
            r += (r / buy[0]) * (sell[0] - buy[0]);
        }
        System.out.println(r);
    }
}
