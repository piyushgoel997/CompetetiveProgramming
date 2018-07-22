import java.util.HashMap;
import java.util.Scanner;

public class BusNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String num = s.next();

        long[] factorials = new long[num.length() + 1];
        factorials[0] = 1;
        for (int i = 1; i <= num.length(); i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        long ans = factorials[num.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            if (map.containsKey(num.charAt(i))) {
                map.put(num.charAt(i), map.get(num.charAt(i)) + 1);
            } else {
                map.put(num.charAt(i), 1);
            }
        }

        // do recursively


        System.out.println(ans);
    }


//    private static long rec(HashMap<Character, Integer> map) {
//
//    }


}
