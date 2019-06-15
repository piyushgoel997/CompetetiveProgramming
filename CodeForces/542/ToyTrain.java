import java.util.ArrayList;
import java.util.Scanner;

public class ToyTrain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = s.nextInt() - 1;
            int y = s.nextInt() - 1;
            if (x != y) list[x].add(y);
        }
        int[] maxDist = new int[n];
        for (int i = 0; i < n; i++) {
            maxDist[i] = 0;
            for (Integer x : list[i]) {
                if (x > i) {
                    maxDist[i] = Math.max(maxDist[i], x - i);
                } else {
                    maxDist[i] = Math.max(maxDist[i], n + x - i);
                }
            }
        }
        int max = 0;
        int maxI = -1;
        for (int i = 0; i < n; i++) {
            if (list[i].size() > max) {
                max = list[i].size();
                maxI = i;
            }
            else if (list[i].size() == max) {
                if (maxI == -1 || maxDist[i] > maxDist[maxI]) {
                    max = list[i].size();
                    maxI = i;
                }
            }
        }

        int a1 = Math.max(max - 1, 0) * n + maxDist[maxI];

        for (int i = 0; i < n; i++) {
            int temp = (maxI+maxDist[maxI])%n;
            int dist = 0;
            while (true) {
                if (temp == i) break;
                temp++;
                dist++;
                temp %= n;
            }
            while (true) {
                if (temp == maxI) break;
                temp++;
                dist++;
                temp %= n;
            }
            if (list[i].size() == max && dist < n) {
                if (i <= maxI) {
                    System.out.println(a1 + maxI - i);
                } else {
                    System.out.println(a1 + n - (i - maxI));
                }
            }else{

                System.out.println(Math.max(max - 1, 0) * n + maxDist[i]);
            }
        }


        System.out.println();
    }
}
