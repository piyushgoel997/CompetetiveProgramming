import java.util.Arrays;
import java.util.Scanner;

public class GettingA {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] marks = new int[n];
        double avg = 0;
        for (int i = 0; i < n; i++) {
            marks[i] = s.nextInt();
            avg += marks[i];
        }
        avg /= n;
        if (avg >= 4.5) {
            System.out.println(0);
            return;
        }
        Arrays.sort(marks);
        double diff = (4.5 - avg) * n;
        int count = 0;
        int i = 0;
        while (diff > 1e-6) {
            count++;
            diff -= (5 - marks[i]);
            i++;
        }
        System.out.println(count);
    }
}
