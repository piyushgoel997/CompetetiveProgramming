import java.util.Arrays;
import java.util.Scanner;

public class Stages {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        char[] available = s.next().toCharArray();
        Arrays.sort(available);
        int stages = 0;
        int x = 0;
        char prev = 'a' - 2;
        for (int i = 0; i < k; i++) {
            while (x < available.length && available[x] < prev + 2) x++;
            if (x == available.length) {
                System.out.println(-1);
                return;
            }
            prev = available[x];
            stages += (int) available[x] - 'a' + 1;
            x++;
        }
        System.out.println(stages);
    }
}
