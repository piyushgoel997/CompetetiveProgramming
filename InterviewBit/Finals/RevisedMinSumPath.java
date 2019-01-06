import java.util.ArrayList;

public class RevisedMinSumPath {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(16);
        A.add(85);
        A.add(6);
        A.add(87);
        A.add(30);
        B.add(83);
        B.add(7);
        B.add(83);
        B.add(87);
        B.add(45);
        System.out.println(solve(A, B, 2, 77));
        System.out.println();
    }
        public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C, int D) {
            cost = new long[2][A.size()+1];
            return (int) Math.min(A.get(0) + dp(true,0,A,B,C,D), B.get(0) + dp(false,0,A,B,C,D));
        }

        private static long[][] cost;


    private static long dp(boolean rowA, int col, ArrayList<Integer> A, ArrayList<Integer> B, int K, int P) {
        int row = 0;
        if (!rowA) row = 1;
        if (col >= A.size() - 1) {
            return 0;
        }
        if (cost[row][col] > 0) return cost[row][col];
        long minCost = 100000000;
        // if (col + K >= A.size() - 1) {
        //     if(rowA) minCost = Math.min(A.get(A.size() - 1), P  + B.get(B.size() - 1));
        //     else minCost = Math.min(B.get(B.size() - 1), P  + A.get(A.size() - 1));
        // } else {
        for (int i = 1; i <= K && col + i < A.size(); i++) {
            if(rowA) {
                minCost = Math.min(minCost, A.get(col + i) + dp(rowA, col + i, A,B,K,P));
                minCost = Math.min(minCost, P  + B.get(col + i) + dp(!rowA, col + i, A,B,K,P));
            } else {
                minCost = Math.min(minCost, B.get(col + i) + dp(rowA, col + i, A,B,K,P));
                minCost = Math.min(minCost, P + A.get(col + i) + dp(!rowA, col + i, A,B,K,P));
            }
        }
        // }
        return cost[row][col] = minCost;
    }


//        private static long dp(boolean rowA, int col, ArrayList<Integer> A, ArrayList<Integer> B, int K, int P) {
//            int row = 0;
//            if (!rowA) row = 1;
//            if (cost[row][col] > 0) return cost[row][col];
//            long minCost = Long.MAX_VALUE;
//            if (col + K >= A.size() - 1) {
//                if(rowA) minCost = Math.min(A.get(A.size() - 1), P + B.get(col) + B.get(B.size() - 1));
//                else minCost = Math.min(B.get(B.size() - 1), P + A.get(col) + A.get(A.size() - 1));
//            } else {
//                for (int i = 1; i <= K; i++) {
//                    if(rowA) {
//                        minCost = Math.min(minCost, A.get(col + i) + dp(rowA, col + i, A,B,K,P));
//                        minCost = Math.min(minCost, P + B.get(col) + B.get(col + i) + dp(!rowA, col + i, A,B,K,P));
//                    } else {
//                        minCost = Math.min(minCost, B.get(col + i) + dp(rowA, col + i, A,B,K,P));
//                        minCost = Math.min(minCost, P + A.get(col) + A.get(col + i) + dp(!rowA, col + i, A,B,K,P));
//                    }
//                }
//            }
//            return cost[row][col] = minCost;
//        }
}
