import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 16-10-2017 at 17:39.
 * 876C
 */
public class ClassroomWatch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int ct = 0;
        ArrayList<Long> list = new ArrayList<>();

        long i = n - 100 > 0 ? n - 100 : 0;
        for (; i < n; i++) {
            if (getSum(String.valueOf(i)) == n) {
                ct++;
                list.add(i);
            }
        }
        System.out.println(ct);
        if (ct > 0) {
            for (Long l : list) {
                System.out.print(l + " ");
            }
        }
    }

    private static long getSum(String s) {
        s = String.valueOf(Long.parseLong(s));
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = Integer.parseInt(s.substring(i, i + 1));
            sum += (Math.pow(10, s.length() - 1 - i) + 1) * c;
        }
        return sum;
    }
//    // 99999515
//    private static Long getLesserNo(long num) {
//        String str = String.valueOf(0_000_000_000L);
//        for (int p = 0; p < str.length(); p++) {
//            for (int i = 9; i >= 0; i--) {
//                String temp = str.substring(0, p) + String.valueOf(i) + str.substring(p + 1);
////                System.out.println(temp);
//                if (getSum(temp) < num) {
////                    System.out.println(str);
//                    str = temp;
//                    break;
//                }
//            }
//        }
//        return Long.parseLong(str);
//    }

}
