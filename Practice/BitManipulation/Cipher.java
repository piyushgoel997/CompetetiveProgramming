package BitManipulation;

import java.util.Scanner;

/**
 * Created by piyus on 21-08-2017 at 00:20.
 * HackerRank. BitManipulation - Medium. Correct.
 */
public class Cipher {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        String inputStr = s.next();
        boolean[] input = new boolean[inputStr.length()];
        for (int i = 0; i < inputStr.length(); i++) {
            input[i] = inputStr.charAt(i) == '1';
        }
        boolean[] output = new boolean[n];
        output[0] = input[0];
        if (k > n) k = n;
        for (int i = 1; i < k; i++) {
            output[i] = input[i - 1] ^ input[i];
        }
        for (int i = k; i < n; i++) {
            for (int j = 1; j < k; j++) {
                output[i] ^= output[i - j];
            }
            output[i] ^= input[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(output[i] ? 1 : 0);
        }
    }

}
