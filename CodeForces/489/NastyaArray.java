import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NastyaArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (x != 0) set.add(x);
        }
        System.out.println(set.size());
    }
}
