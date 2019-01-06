import java.util.Scanner;

public class Elections {
    private static long[][] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Voter[] voter = new Voter[n];
        int[] party = new int[m+1];
        for (int i = 0; i < n; i++) {
            int p = s.nextInt();
            long c = s.nextLong();
            voter[i] = new Voter(p, c);
            party[p] += 1;
        }
        int max = 0;
        for (int i = 2; i <= m; i++) max = Math.max(max, party[i]);
        dp = new long[n + 1][n + 3];
        System.out.println(minCost(0, Math.max(0, max + 1 - party[1]), party, voter));
    }

    private static long minCost(int i, int rqd, int[] party, Voter[] voter) {
        if (rqd <= 0) return 0;
        if (i >= voter.length) return 999999999999L;
        if (rqd > voter.length - i + 1) return 999999999999L;
        if (dp[i][rqd] != 0) return dp[i][rqd];
        if (voter[i].party == 1) return minCost(i + 1, rqd, party, voter);
        // dont buy
        long min = minCost(i + 1, rqd, party, voter);
        // buy
        party[voter[i].party] -= 1;
        party[1] += 1;
        int newrqd = 0;
        for (int j = 2; j < party.length; j++) newrqd = Math.max(newrqd, party[j]);
        min = Math.min(min, voter[i].cost + minCost(i + 1, Math.max(0, newrqd + 1 - party[1]), party, voter));
        party[voter[i].party] += 1;
        party[1] -= 1;
        return dp[i][rqd] = min;
    }

    private static class Voter {
        int party;
        long cost;

        Voter(int party, long cost) {
            this.party = party;
            this.cost = cost;
        }
    }
    
}
