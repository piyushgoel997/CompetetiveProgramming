import java.util.List;

public class EfficientCost {
    public static void main(String[] args) {

    }

    static int calculateCost(List<Integer> a, int k) {
        int[] micCost = new int[a.size() + 1];
        return dp(a, k, micCost, 0);
    }

    private static int dp(List<Integer> a, int k, int[] micCost, int i) {
        if (i >= a.size()) return 0;
        if (micCost[i] > 0) return micCost[i];
        int max = 0;
        int cost = Integer.MAX_VALUE;
        for (int j = i; j < Math.min(i + k, a.size()); j++) {
            max = Math.max(max, a.get(j));
            cost = Math.min(cost, max + dp(a, k, micCost, j + 1));
        }
        return micCost[i] = cost;
    }

}
