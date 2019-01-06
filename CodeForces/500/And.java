import java.util.HashSet;
import java.util.Scanner;

public class And {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        HashSet<Integer> numbers = new HashSet<>();
        HashSet<Integer> ands = new HashSet<>();
        int min = 10;
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            if (numbers.contains(num)) min = Math.min(0, min);
            if (numbers.contains(num & x) || ands.contains(num)) min = Math.min(1, min);
            if (ands.contains(num & x)) min = Math.min(2, min);
            numbers.add(num);
            ands.add(num & x);
        }
        if (min == 10) System.out.println(-1);
        else System.out.println(min);
    }
}