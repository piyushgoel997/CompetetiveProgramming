import java.util.Scanner;

public class A506 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        String t = s.next();
        int intersection = -1;
        for (int i = 1; i < n; i++) {
            boolean possible = true;
            for (int j = 0; i + j < n; j++) {
                if (t.charAt(i + j) != t.charAt(j)) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                intersection = i;
                break;
            }
        }
        if (intersection == -1) {
            for (int i = 0; i < k; i++) {
                System.out.print(t);
            }
            return;
        }
        System.out.print(t);
        for (int i = 0; i < k - 1; i++) {
            System.out.print(t.substring(n - intersection));
        }
    }
}
