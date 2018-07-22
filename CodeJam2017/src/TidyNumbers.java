import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyus on 08-04-2017.
 */
public class TidyNumbers {
    private static boolean checkTidy(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] > num[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] toArr(long num) {
        long temp = num;
        int i = 0;
        while (temp != 0) {
            temp = temp / 10;
            i++;
        }
        int[] arr = new int[i];
        temp = num;
        while (temp != 0) {
            arr[--i] = (int) (temp % 10);
            temp = temp / 10;
        }
        return arr;
    }

    private static long findTidyNum(long num) {
        for (long i = num; i > 0; i--) {
            if (checkTidy(toArr(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        long[] arr = new long[t];
        for (int i = 0; i < t; i++) {
            arr[i] = s.nextLong();
        }
        long[] ans = new long[t];
        for (int i = 0; i < t; i++) {
            ans[i] = tidyNumBetter(arr[i]);

        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i+1) + ": " + ans[i]);
        }
    }

    //   11111111111111110
    private static long tidyNumBetter(long num) {
        num = clean(num);
        num = clean2(num);
        long temp = num;
        long i = 0;
        while(temp!=0){
            long curr = (num / (long)(Math.pow(10, i + 1)));
            long x = (num / (long)(Math.pow(10, i))) % 10;
            if (x == 0) {
                curr--;
                x = 9;
            }
            while (x < (curr % 10)) {
                if (x == 0) {
                    curr--;
                    x = 9;
                } else {
                    x--;
                }
            }
            long a = (num % (long)Math.pow(10, i));
            long b =  (x * (long)Math.pow(10, i));
            long c =  (curr * (long)Math.pow(10, i + 1));
            long newNum = (a + b + c);

            num = newNum;
            i++;
            temp =  (newNum / (long)Math.pow(10, i));
        }
        return num;
    }

    private static long clean2(long num) {
        long temp = num;
        int i = 0;
        int maxi = 1;
        long prev = 0;
        while (temp != 0) {
            long curr = temp % 10;
            if (i > 0) {
                if (curr > prev) {
                    maxi = i;
                }
            }
            prev = curr;
            i++;
            temp /= 10;
        }
        return (num / (long) Math.pow(10, maxi-1)) * ((long) Math.pow(10, maxi-1));
    }

    private static long clean(long num) {
        long temp = num;
        int i = 0;
        int maxi = 0;
        while (temp != 0) {
            if (temp % 10 == 0) {
                maxi = i;
            }
            i++;
            temp /= 10;
        }
        return (num / (long) Math.pow(10, maxi)) * ((long) Math.pow(10, maxi));
    }
}
