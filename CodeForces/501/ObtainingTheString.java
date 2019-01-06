import java.util.ArrayList;
import java.util.Scanner;

public class ObtainingTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        ArrayList<Integer> moves = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != t.charAt(i)) {
                boolean found = false;
                for (int j = i; j >= 0; j--) {
                    if (s.charAt(j) == t.charAt(i)) {
                        found = true;
                        s = s.substring(0, j) + s.substring(j + 1, i + 1) + s.charAt(j) + s.substring(i + 1);
                        for (int k = j; k < i; k++) {
                            moves.add(k);
                        }
                    }
                }
                if (!found) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(moves.size());
        for (Integer i : moves) {
            System.out.print((i + 1) + " ");
        }
    }
}
