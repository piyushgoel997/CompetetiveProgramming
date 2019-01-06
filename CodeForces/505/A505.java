import java.util.Scanner;

public class A505 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        int[] counts = new int['z' - 'a' + 1];
        for (int i = 0; i < n; i++) counts[str.charAt(i) - 'a'] += 1;
        boolean possible = false;
        if (n == 1) {
            System.out.println("YES");
            return;
        }
        for (int count : counts) {
            if (count >= 2) {
                possible = true;
                break;
            }
        }
        if (possible) System.out.println("YES");
        else System.out.println("NO");
    }
}
