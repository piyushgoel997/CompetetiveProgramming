import java.util.Scanner;

public class Badge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = p[j] - 1;
            }
            System.out.print(j + 1);
            System.out.print(" ");
        }
    }
}
