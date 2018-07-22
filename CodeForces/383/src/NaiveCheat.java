import java.util.Scanner;

/**
 * Created by Piyush on 06-12-2016.
 */
public class NaiveCheat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n == 0) {
            System.out.print(1);
            return;
        }
        int x = n % 4;
        int ans;
        switch (x) {
            case 1:
                ans = 8;
                break;
            case 2:
                ans = 4;
                break;
            case 3:
                ans = 2;
                break;
            default:
                ans = 6;
                break;
        }
        System.out.println(ans);
    }


}
