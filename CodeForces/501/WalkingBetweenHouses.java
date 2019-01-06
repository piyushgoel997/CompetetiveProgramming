import java.util.ArrayList;
import java.util.Scanner;

public class WalkingBetweenHouses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long s = scanner.nextLong();

        long dist = 0;

        if (s > k * (n - 1)) {
            System.out.println("NO");
            return;
        }

        ArrayList<Integer> pts = new ArrayList<>();
        pts.add(1);  /////////

        while (true) {
            if (s - (dist + n - 1) <= k) {
                if (pts.get(pts.size() - 1) == 1) pts.add(n);
                else pts.add(1);
                dist += n - 1;
            } else break;
        }

        while (true) {

        }

    }
}
