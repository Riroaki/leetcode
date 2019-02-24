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

class UniquePaths2Naive {
    private int totalPathCount;

    private void findPathRecursive(int[][] map, int currX, int currY) {
        if (currX == map.length - 1 && currY == map[0].length - 1 && map[currX][currY] == 0)
            totalPathCount++;
        if (currX < map.length - 1 && map[currX + 1][currY] == 0)
            findPathRecursive(map, currX + 1, currY);
        if (currY < map[0].length - 1 && map[currX][currY + 1] == 0)
            findPathRecursive(map, currX, currY + 1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        totalPathCount = 0;
        if (obstacleGrid[0][0] == 1)
            return 0;
        findPathRecursive(obstacleGrid, 0, 0);
        return totalPathCount;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
