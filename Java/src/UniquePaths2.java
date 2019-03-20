// Uses dynamic programming.
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        // dp[i] means how many paths to arrive obstacleGrid[some row][i]
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                // If there is an obstacle, it's impossible to get there.
                if (row[i] == 1)
                    dp[i] = 0;
                // Else we can get there from above and left
                    // (the original value of dp[i] and dp[i - 1])
                else if (i > 0)
                    dp[i] += dp[i - 1];
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(new int[][]{{1, 0}}));
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(new int[][]{{1}}));
    }
}
