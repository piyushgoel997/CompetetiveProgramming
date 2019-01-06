import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumbersOnChessboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long x = ((r - 1) / 2) * n;
            if ((r + c) % 2 == 0) {
                x += ((r - 1) % 2) * (1 + n) / 2;
                System.out.println(x + 1 + ((c - 1) / 2));
            } else {
                x += ((r - 1) % 2) * (n / 2);
                System.out.println(x + 1 + (((n * n) + 1) / 2) + ((c - 1) / 2));
            }
        }
    }
}
