import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temporary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[][][] intersections = new int[q + 1][q + 1][4];
            //nsew
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);
                switch (d) {
                    case 'S':
                        intersections[x][y][0]++;
                        break;
                    case 'N':
                        intersections[x][y][1]++;
                        break;
                    case 'E':
                        intersections[x][y][2]++;
                        break;
                    case 'W':
                        intersections[x][y][3]++;
                        break;
                }
            }
            int s = 0;
            for (int j = 0; j < q + 1; j++) {
                s += intersections[0][j][1];
            }
            for (int j = 0; j < q + 1; j++) {
                intersections[0][j][1] = s;
            }
            for (int i = 1; i < q + 1; i++) {
                for (int j = 0; j < q + 1; j++) {
                    s += intersections[i][j][1];
                }
                for (int j = 0; j < q + 1; j++) {
                    intersections[i][j][1] = s;
                }
            }
            int n = 0;
            for (int j = 0; j < q + 1; j++) {
                n += intersections[q][j][0];
            }
            for (int j = 0; j < q + 1; j++) {
                intersections[q][j][0] = n;
            }
            for (int i = q - 1; i >= 0; i--) {
                for (int j = 0; j < q + 1; j++) {
                    n += intersections[i][j][0];
                }
                for (int j = 0; j < q + 1; j++) {
                    intersections[i][j][0] = n;
                }
            }

            int e = 0;
            for (int i = 0; i < q + 1; i++) {
                e += intersections[i][0][2];
            }
            for (int i = 0; i < q + 1; i++) {
                intersections[i][0][2] = e;
            }
            for (int j = 1; j < q + 1; j++) {
                for (int i = 0; i < q + 1; i++) {
                    e += intersections[i][j][2];
                }
                for (int i = 0; i < q + 1; i++) {
                    intersections[i][j][2] = e;
                }
            }
            int w = 0;
            for (int i = 0; i < q + 1; i++) {
                w += intersections[i][q][3];
            }
            for (int i = 0; i < q + 1; i++) {
                intersections[i][q][3] = w;
            }
            for (int j = q - 1; j >= 0; j--) {
                for (int i = 0; i < q + 1; i++) {
                    w += intersections[i][j][3];
                }
                for (int i = 0; i < q + 1; i++) {
                    intersections[i][j][3] = w;
                }
            }
//            for (int i = 1; i < q + 1; i++) {
//                for (int j = 1; j < q + 1; j++) {
//                    intersections[i][j][1] += intersections[i][j - 1][1];
//                    intersections[i][j][3] += intersections[i - 1][j][3];
//                }
//            }
//            for (int i = q - 1; i >= 0; i--) {
//                for (int j = q - 1; j >= 0; j--) {
//                    intersections[i][j][0] += intersections[i][j + 1][0];
//                    intersections[i][j][2] += intersections[i + 1][j][2];
//                }
//            }
            int max = 0;
            int mi = 0, mj = 0;
            for (int i = 1; i < q; i++) {
                for (int j = 1; j < q; j++) {
                    int temp2 = intersections[i - 1][j][2] + intersections[i][j - 1][1] + intersections[i][j + 1][0] + intersections[i + 1][j][3];
                    if (temp2 > max) {
                        max = temp2;
                        mi = i;
                        mj = j;
                    }
                }
            }
            // y = 0
            for (int i = 1; i < q; i++) {
                int j = 0;
                int temp2 = intersections[i - 1][j][2] + intersections[i][j + 1][0] + intersections[i + 1][j][3];
                if (temp2 > max || (temp2 == max && mi >= i)) {
                    max = temp2;
                    mi = i;
                    mj = j;
                }
            }
            // y = q
            for (int i = 1; i < q; i++) {
                int j = q;
                int temp2 = intersections[i - 1][j][2] + intersections[i][j - 1][1] + intersections[i + 1][j][3];
                if (temp2 > max) {
                    max = temp2;
                    mi = i;
                    mj = j;
                }
            }
            // x = 0
            for (int j = 1; j < q; j++) {
                int i = 0;
                int temp2 = intersections[i][j - 1][1] + intersections[i][j + 1][0] + intersections[i + 1][j][3];
                if (temp2 > max || (temp2 == max && mj >= j)) {
                    max = temp2;
                    mi = i;
                    mj = j;
                }
            }
            // x = q
            for (int j = 1; j < q; j++) {
                int i = q;
                int temp2 = intersections[i][j - 1][1] + intersections[i - 1][j][2] + intersections[i][j + 1][0];
                if (temp2 > max) {
                    max = temp2;
                    mi = i;
                    mj = j;
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + mi + " " + mj);
        }
    }
}
