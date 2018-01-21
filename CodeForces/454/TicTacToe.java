import java.util.Scanner;

/**
 * Created by piyus on 23-12-2017 at 19:55.
 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] t = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String str = s.nextLine();
            if (str.length() == 0){
                str = s.nextLine();
            }
            int x = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
//                    System.out.println(x + k + j*3);
                    t[i][j*3 + k] = str.charAt(x + k + j*3);
                }
                x++;
            }
        }
        int v = s.nextInt();
        int h = s.nextInt();
        switch (v % 3) {
            case 0:
                //lowest row
                switch (h % 3) {
                    case 0:
                        //rightmost col
                        if (checkSpace(t, 6, 8, 6, 8)) printT(t, false);
                        else printT(t, true);
                        break;
                    case 1:
                        //leftmost col
                        if (checkSpace(t, 6, 8, 0, 2)) printT(t, false);
                        else printT(t, true);
                        break;
                    case 2:
                        // middle col
                        if (checkSpace(t, 6, 8, 3, 5)) printT(t, false);
                        else printT(t, true);
                        break;
                }

                break;
            case 1:
                // upper row
                switch (h % 3) {
                    case 0:
                        //rightmost col
                        if (checkSpace(t, 0, 2, 6, 8)) printT(t, false);
                        else printT(t, true);
                        break;
                    case 1:
                        //leftmost col
                        if (checkSpace(t, 0, 2, 0, 2)) printT(t, false);
                        else printT(t, true);
                        break;
                    case 2:
                        // middle col
                        if (checkSpace(t, 0, 2, 3, 5)) printT(t, false);
                        else printT(t, true);
                        break;
                }

                break;
            case 2:
                // middle row
                switch (h % 3) {
                    case 0:
                        //rightmost col
                        if (checkSpace(t, 3, 5, 6, 8)) printT(t, false);
                        else printT(t, true);
                        break;
                    case 1:
                        //leftmost col
                        if (checkSpace(t, 3, 5, 0, 2)) printT(t, false);
                        else printT(t, true);
                        break;
                    case 2:
                        // middle col
                        if (checkSpace(t, 3, 5, 3, 5)) printT(t, false);
                        else printT(t, true);
                        break;
                }

                break;
        }
    }

    private static void printT(char[][] t, boolean changeRqd) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (changeRqd && t[i][j*3 + k] == '.') System.out.print("!");
                    else System.out.print(t[i][j*3 + k]);
                }
                System.out.print(" ");
            }
            System.out.println();
            if (i % 3 == 2) System.out.println();
        }
    }

    private static boolean checkSpace(char[][] t, int vs, int ve, int hs, int he) {
        boolean hasSpace = false;
        for (int v = vs; v <= ve; v++) {
            for (int h = hs; h <= he; h++) {
                if (t[v][h] == '.') {
                    hasSpace = true;
                    t[v][h] = '!';
                }
            }
        }
        return hasSpace;
    }
}
