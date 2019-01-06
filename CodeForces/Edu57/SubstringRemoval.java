import java.util.Scanner;

public class SubstringRemoval {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long m = 998244353;
        String str = s.next();
        int i = 1;
        while (i < n && str.charAt(i) == str.charAt(i - 1)) i++;
        int j = (int) n - 2;
        while (j >= 0 && str.charAt(j) == str.charAt(j + 1)) j--;

        if (i == n) {
            System.out.println((((n * (n + 1)) / 2) - 1) % m);
            return;
        }
        long x = n - j - 1;
        long y = i;
        if (str.charAt(0) == str.charAt((int) n - 1)) {
            System.out.println(((x * y) + y + x + 1) % m);
        } else {
            System.out.println((x + y + 1) % m);
        }
    }
}
