import java.util.Scanner;

public class A503 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long h = s.nextLong();
        long a = s.nextLong();
        long b = s.nextLong();
        int k = s.nextInt();

        for (int i = 0; i < k; i++) {
            long ta = s.nextLong();
            long fa = s.nextLong();
            long tb = s.nextLong();
            long fb = s.nextLong();
            if (ta == tb) {
                System.out.println(Math.abs(fa - fb));
                continue;
            }
            long time = 0;
            if (fa > b) {
                time += fa - b;
                fa = b;
            } else if (fa < a) {
                time += a - fa;
                fa = a;
            }
            time += Math.abs(fa - fb);
            time += Math.abs(ta - tb);
            System.out.println(time);
        }

    }
}
