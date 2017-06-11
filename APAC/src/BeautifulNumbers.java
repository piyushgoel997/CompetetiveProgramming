import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by piyus on 12-06-2017 at 01:39.
 */
public class BeautifulNumbers {
    private static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            long n = s.nextLong();
            long ans = solve(n);
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }

    private static long solve(long n) {
        ArrayList<Long> factors = allFactors(n - 1);
        Collections.reverse(factors);
        factors.remove(factors.size() - 1);
        long ans = n - 1;
        for (long x : factors) {
            long temp = n - 1;
            while (temp != 0) {
                temp /= x;
                if ((temp - 1) % x != 0) {
                    break;
                }
                temp -= 1;
            }
            if (temp == 0) {
                ans = x;
            }
        }
        return ans;
    }

    public static ArrayList<Long> allFactors(long a) {
        long upperlimit = (long)(Math.sqrt(a));
        ArrayList<Long> factors = new ArrayList<>();
        for(long i=1;i <= upperlimit; i+= 1){
            if(a%i == 0){
                factors.add(i);
                if(i != a/i){
                    factors.add(a/i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }
}
