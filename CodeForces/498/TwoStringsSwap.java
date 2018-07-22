import java.util.Scanner;

public class TwoStringsSwap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String a = s.next();
        String b = s.next();
        int swaps = 0;
        int i = 0;
        while (i < n / 2) {

            if (b.charAt(i) == b.charAt(n - i - 1)) {
                if (a.charAt(i) != a.charAt(n - 1 - i)) {
                    swaps += 1;
                }
            } else {
                int temp = 2;
                if (a.charAt(i) == b.charAt(i)) {
                    temp--;
                    if (a.charAt(n - 1 - i) == b.charAt(n - 1 - i)) {
                        temp--;
                    }
                } else if (a.charAt(i) == b.charAt(n - i - 1)) {
                    temp--;
                    if (a.charAt(n - 1 - i) == b.charAt(i)) {
                        temp--;
                    }
                } else if (a.charAt(n - 1 - i) == b.charAt(i)) {
                    temp--;
                } else if (a.charAt(n - 1 - i) == b.charAt(n - 1 - i)) {
                    temp--;
                }
                swaps += temp;
            }

            i++;
        }
        if (n % 2 == 1) {
            if (a.charAt(n / 2) != b.charAt(n / 2)) {
                swaps++;
            }
        }
        System.out.println(swaps);
    }
}
