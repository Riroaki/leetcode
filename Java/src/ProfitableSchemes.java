import java.util.Arrays;

public class ProfitableSchemes {
//    private int res, goal, limit;
//    private final int MOD = 1_000_000_007;
//
//    private void helper(int currentPeople, int currentProfit, int[] group, int[] profit, int indexOfCrime) {
//        System.out.println("calling " + currentPeople + " " + currentProfit);
//        if (currentProfit >= goal)
//            res++;
//        if (res >= MOD)
//            res -= MOD;
//        if (indexOfCrime >= group.length)
//            return;
//        if (currentPeople + group[indexOfCrime] <= limit)
//            helper(currentPeople + group[indexOfCrime], currentProfit + profit[indexOfCrime], group, profit, indexOfCrime + 1);
//        helper(currentPeople, currentProfit, group, profit, indexOfCrime + 1);
//    }
//
//    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
//        res = 0;
//        goal = P;
//        limit = G;
//        helper(0, 0, group, profit, 0);
//        return res;
//    }

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int N = group.length;
        long[][][] dp = new long[2][P + 1][G + 1];
        dp[0][0][0] = 1;

        for (int i = 0; i < N; ++i) {
            int p0 = profit[i];  // the current crime profit
            int g0 = group[i];  // the current crime group size

            long[][] cur = dp[i % 2];
            long[][] cur2 = dp[(i + 1) % 2];

            // Deep copy cur into cur2
            for (int jp = 0; jp <= P; ++jp)
                for (int jg = 0; jg <= G; ++jg)
                    cur2[jp][jg] = cur[jp][jg];

            for (int p1 = 0; p1 <= P; ++p1) {  // p1 : the current profit
                // p2 : the new profit after committing this crime
                int p2 = Math.min(p1 + p0, P);
                for (int g1 = 0; g1 <= G - g0; ++g1) {  // g1 : the current group size
                    // g2 : the new group size after committing this crime
                    int g2 = g1 + g0;
                    cur2[p2][g2] += cur[p1][g1];
                    cur2[p2][g2] %= MOD;
                }
            }
        }

        // Sum all schemes with profit P and group size 0 <= g <= G.
        long ans = 0;
        for (long x : dp[N % 2][P])
            ans += x;

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new ProfitableSchemes().profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
    }
}
