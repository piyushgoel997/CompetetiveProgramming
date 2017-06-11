import java.util.Scanner;

/**
 * Created by Piyush on 26-01-2017.
 */
// correct
public class Store_Credit {

    static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve());
        }
    }

    private static String solve() {
        int c = s.nextInt();
        int l = s.nextInt();
        int[] arr = new int[l];
        for (int j = 0; j < l; j++) {
            arr[j] = s.nextInt();
        }
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (arr[i] + arr[j] == c) {
                    return (i+1) + " " + (j+1);
                }
            }
        }
        return null;
    }

}
