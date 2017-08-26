package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by piyus on 18-08-2017 at 11:09.
 * HackerEarth. DP - Medium. Correct.
 */
public class NumOfRs {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println(maxR(s.next()));
        }
    }

    private static int maxR(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int currK = 0;
        int numR = 0;
        int max = 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == 'R') {
            numR++;
            i++;
        }
        boolean flag = true;
        while (i < str.length()) {
            if (str.charAt(i) == 'K') {
                flag = false;
                currK++;
                if (currK > max) {
                    max = currK;
                }
            } else if (str.charAt(i) == 'R') {
                currK--;
                numR++;
            }
            if (currK < 0) {
                currK = 0;
//                while (i < str.length() && str.charAt(i) == 'R') {
//                    numR++;
//                    i++;
//                }
            }
            i++;
        }
        if (flag) numR--;
        return numR + max;
    }
}
