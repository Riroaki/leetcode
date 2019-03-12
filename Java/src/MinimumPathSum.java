public class MinimumPathSum {
    // 因为只能从上面或者左侧抵达某个值，所以dp[row][col] = min(dp[row - 1][col], dp[row][col - 1]) + grid[i][j].
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid.length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            dp[i] = dp[i - 1] + grid[0][i];
        for (int row = 1; row < m; row++) {
            dp[0] += grid[row][0];
            for (int col = 0; col < n; col++)
                dp[col] = Math.min(dp[col - 1], dp[col]) + grid[row][col];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
