import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fingerprints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] seq = new int[n];
        Set<Integer> fp = new HashSet<>();
        for (int i = 0; i < n; i++) seq[i] = scanner.nextInt();
        for (int i = 0; i < m; i++) fp.add(scanner.nextInt());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (fp.contains(seq[i])) list.add(seq[i]);
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
    }
}
