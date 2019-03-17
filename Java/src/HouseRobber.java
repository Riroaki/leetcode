public class HouseRobber {
    // dp formula: rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

    // dp[i][0] means not to rob i, while dp[i][1] means to rob i.
    public int robNaive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // Convert it into O(1) space
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int take = nums[0], notTake = 0;
        for (int i = 1; i < n; i++) {
            int tmp1 = Math.max(take, notTake);
            int tmp2 = notTake + nums[i];
            notTake = tmp1;
            take = tmp2;
        }
        return Math.max(take, notTake);
    }
}
