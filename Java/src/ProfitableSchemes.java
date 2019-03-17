import java.util.*;

public class ProfitableSchemes {
    // TLE, naive version.
        // 2^n search space (time complexity).
    /*
    private int goal, limit;
    private long res;
    private int[] groups, profits;
    
    private void helper(int people, int profit, int index) {
        if (index == groups.length) {
            if (profit >= goal)
                res++;
            return;
        }
        if (groups[index] + people <= limit)
            helper(people + groups[index], profit + profits[index], index + 1);
        helper(people, profit, index + 1);
    }
    
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        res = 0;
        goal = P;
        limit = G;
        groups = group;
        profits = profit;
        helper(0, 0, 0);
        return (int)(res % 1_000_000_007);
    }
    */
    
    // 这里是2d的做法。需要reverse looping是因为，我们需要用旧的值更新，而我们更新是用左边的值更新右边的
        // 如果我们从左往右更新，那么右边的值还没有用于更新就已经被污染；
        // 从右往左更新就不会出现这样的情况。
        // 然后这里对方案选取的循环必须放在最外层，因为每个方案只能选一次，放在最外层体天然保证了这一点
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][G + 1];
        int MOD = (int)1e9 + 7, res = 0, n = group.length;
        dp[0][0] = 1;
        for (int k = 0; k < n; k++) {
            for (int i = P; i >= 0; i--) {
                for (int j = G - group[k]; j >= 0; j--) {
                    if (i + profit[k] < P)
                        dp[i + profit[k]][j + g] = (dp[i + profit[k]][j + g] + dp[i][j]) % MOD;
                    else
                        dp[P][j + g] = (dp[P][j + g] + dp[i][j]) % MOD;
                }
            }
        }
        for (int i : dp[P])
            res = (res + i) % MOD;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProfitableSchemes().profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
    }
}
