import java.util.Scanner;

public class Vitamins {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] cost = new int[n];
        boolean[][] vit = new boolean[n][3];
        boolean noA = true, noB = true, noC = true;
        for (int i = 0; i < n; i++) {
            cost[i] = s.nextInt();
            String str = s.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'A') {
                    noA = false;
                    vit[i][0] = true;
                } else if (str.charAt(j) == 'B') {
                    noB = false;
                    vit[i][1] = true;
                } else if (str.charAt(j) == 'C') {
                    noC = false;
                    vit[i][2] = true;
                }
            }
        }
        if (noA || noB || noC) {
            System.out.println(-1);
            return;
        }

        int minA = 999999;
        int minB = 999999;
        int minC = 999999;
        int minAB = 999999;
        int minAC = 999999;
        int minBC = 999999;
        int minABC = 999999;

        for (int i = 0; i < n; i++) {
            if (vit[i][0]) {
                minA = Math.min(minA, cost[i]);
                if (vit[i][1]) {
                    minAB = Math.min(minAB, cost[i]);
                    if (vit[i][2]) {
                        minABC = Math.min(minABC, cost[i]);
                    }
                }
                if (vit[i][2]) {
                    minAC = Math.min(minAC, cost[i]);
                }
            }
            if (vit[i][1]) {
                minB = Math.min(minB, cost[i]);
                if (vit[i][2]) {
                    minBC = Math.min(minBC, cost[i]);
                }
            }
            if (vit[i][2]) {
                minC = Math.min(minC, cost[i]);
            }
        }

        int minCost = Math.min(Math.min(minA + minBC, minB + minAC), Math.min(minC + minAB, minABC));
        minCost = Math.min(minCost, minA + minB + minC);
        System.out.println(minCost);

    }

}
