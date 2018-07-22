import java.util.Scanner;

/**
 * Created by piyus on 27-12-2017 at 22:06.
 */
public class GenerateLogin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String f = s.next();
        String l = s.next();
        StringBuilder uf = new StringBuilder().append(f.charAt(0));
        for (int i = 1; i < f.length(); i++) {
            if (f.charAt(i) < l.charAt(0)) {
                uf.append(f.charAt(i));
            } else {
                break;
            }
        }
        System.out.println(uf.append(l.charAt(0)));
    }
}
