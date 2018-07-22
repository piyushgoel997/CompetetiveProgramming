import java.util.Scanner;

/**
 * Created by piyus on 19-12-2017 at 22:02.
 */
public class HashingTrees {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int[] choices = new int[h + 1];
        boolean perfect = true;
        for (int i = 0; i < choices.length; i++) {
            choices[i] = s.nextInt();
            if (i > 0 && choices[i] > 1) {
                if (choices[i - 1] > 1) {
                    perfect = false;
                }
            }
        }

        if (perfect) {
            System.out.println("perfect");
            return;
        }

        System.out.println("ambiguous");
        int p = 0;
        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < choices[i]; j++) System.out.print(p + " ");
            p += choices[i];
        }

        System.out.println();

        System.out.print(0 + " ");
        p = 1;
        for (int i = 1; i < choices.length; i++) {
            if (choices[i - 1] > 1) System.out.print((p - 1) + " ");
            else System.out.print(p + " ");
            for (int j = 1; j < choices[i]; j++) System.out.print(p + " ");
            p += choices[i];
        }
    }
}
