import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeReligions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String word = br.readLine();
        StringBuilder[] religion = new StringBuilder[3];
        for (int i = 0; i < q; i++) {
            String str = br.readLine();
            if (str.charAt(0) == '+') religion[str.charAt(2) - '1'].append(str.charAt(4));
            else religion[str.charAt(2) - '1'].deleteCharAt(religion[str.charAt(2) - '1'].length() - 1);
//            table = new boolean[][3][n];
            Arrays.fill(table, -1);
//            dp(0, 0, 0, 0, word, religion);
        }
    }

//    private static boolean dp(int i, int one, int two, int three, String word, StringBuilder[] religion) {
//        if (one >= religion[0].length() && (two >= religion[1].length() && three >= religion[2].length())) return true;
//        if (i >= word.length()) return false;
//
//    }

    private static int[][] table;

}
