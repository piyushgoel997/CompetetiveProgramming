import java.util.Scanner;

/**
 * Created by Piyush on 06-01-2017.
 */
public class IlyaTicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] arr = new char[4][4];
        for (int i = 0; i < 4; i++) {
            String str = s.nextLine();
            if (str.contains("xx.")||str.contains(".xx")||str.contains("x.x")) {
                System.out.print("YES");
                return;
            }
            for (int j = 0; j < 4; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 4; i++) {
            String str = "" + arr[0][i] + arr[1][i] + arr[2][i] + arr[3][i];
            if (str.contains("xx.")||str.contains(".xx")||str.contains("x.x")) {
                System.out.print("YES");
                return;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String str = "" + arr[i][j] + arr[i + 1][j + 1] + arr[i + 2][j + 2];
                if (str.equals("xx.") || str.equals(".xx") || str.equals("x.x")) {
                    System.out.print("YES");
                    return;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 3; j > 1; j--) {
                String str = "" + arr[i][j] + arr[i + 1][j - 1] + arr[i + 2][j - 2];
                if (str.equals("xx.") || str.equals(".xx") || str.equals("x.x")) {
                    System.out.print("YES");
                    return;
                }
            }
        }
        System.out.print("NO");
        return;
    }
}
