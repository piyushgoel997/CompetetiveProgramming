import java.util.Scanner;

public class HitLottery {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long l = s.nextLong();
        int ct = 0;
        ct += l / 100;
        l %= 100;
        ct += l / 20;
        l %= 20;
        ct += l / 10;
        l %= 10;
        ct += l / 5;
        l %= 5;
        ct += l;
        System.out.println(ct);
    }
}
