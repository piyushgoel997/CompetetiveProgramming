import java.util.Scanner;

public class Connect542 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] start = new int[2];
        int[] end = new int[2];
        int n = s.nextInt();
        start[0] = s.nextInt() - 1;
        start[1] = s.nextInt() - 1;
        end[0] = s.nextInt() - 1;
        end[1] = s.nextInt() - 1;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = s.next();
            for (int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        work(start, n, 2);
        if (map[end[0]][end[1]] == 2) {
            System.out.println(0);
            return;
        }
        work(end, n, 3);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (map[k][l] == 3) {
                                min = Math.min(min, (i - k) * (i - k) + (j - l) * (j - l));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

    // 0 land, 1 water
    private static int[][] map;

    private static void work(int[] start, int n, int x) {
        map[start[0]][start[1]] = x;
        if (start[0] + 1 < n && map[start[0] + 1][start[1]] == 0) {
            map[start[0] + 1][start[1]] = x;
            work(new int[]{start[0] + 1, start[1]}, n, x);
        }
        if (start[0] - 1 >= 0 && map[start[0] - 1][start[1]] == 0) {
            map[start[0] - 1][start[1]] = x;
            work(new int[]{start[0] - 1, start[1]}, n, x);
        }
        if (start[1] + 1 < n && map[start[0]][start[1] + 1] == 0) {
            map[start[0]][start[1] + 1] = x;
            work(new int[]{start[0], start[1] + 1}, n, x);
        }
        if (start[1] - 1 >= 0 && map[start[0]][start[1] - 1] == 0) {
            map[start[0]][start[1] - 1] = x;
            work(new int[]{start[0], start[1] - 1}, n, x);
        }
    }
}
