import java.util.Scanner;

public class Riverscape {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int p = s.nextInt();
        char[] inp = s.next().toCharArray();
        if (n == p) {
            char prev = 0;
            for (int i = 0; i < inp.length; i++) {
                if (inp[i] == '.') {
                    if (prev == '1'){
                        System.out.print('0');
                        prev = 0;
                    }
                    else {
                        System.out.print('1');
                        prev = '1';
                    }
                }
                else {
                    System.out.print(inp[i]);
                    prev = inp[i];
                }
            }
            return;
        }
        boolean eq = true;
        for (int i = 0; i < p; i++) {
            char prev = inp[i];
            for (int j = 1; j < (int) Math.ceil((1.0 * n) / p); j++) {
                int x = (j * p) + i;
                if (x >= inp.length) break;
                if (inp[x] != prev ) {
                    if (prev == '.') {
                        if (inp[x] == '1') inp[i] = '0';
                        else inp[i] = '1';
                    } else if (inp[x] == '.') {
                        if (prev == '1') inp[x] = '0';
                        else inp[x] = '1';
                    }
                    eq = false;
                    break;
                }
                if (inp[x] == prev && prev == '.') {
                    inp[x] = '1';
                    eq = false;
                    break;
                }
            }
            if (!eq) {
                break;
            }
        }

        if (eq) {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < inp.length; i++) {
            if (inp[i] == '.') {
                System.out.print('0');
            } else {
                System.out.print(inp[i]);
            }
        }
    }
}
