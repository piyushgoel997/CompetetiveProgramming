import java.util.Scanner;

/**
 * Created by Piyush on 12-01-2017.
 */
public class A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int n = chars.length;
        int B = 0;
        int u = 0;
        int l = 0;
        int b = 0;
        int a = 0;
        int s = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            switch (chars[i]){
                case 'B':
                    B++;
                    break;
                case 'u':
                    u++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 's':
                    s++;
                    break;
                case 'r':
                    r++;
                    break;
            }
        }
        a = a / 2;
        u = u / 2;

        int ans = Math.min(Math.min(Math.min(B, u), Math.min(l, b)), Math.min(Math.min(a, s), r));
        System.out.println(ans);
    }
}
