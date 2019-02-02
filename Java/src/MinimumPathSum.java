public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int[] pathSum = new int[width];
        pathSum[0] = grid[0][0];
        for (int i = 1; i < width; i++)
            pathSum[i] = pathSum[i - 1] + grid[0][i];
        for (int row = 1; row < grid.length; row++) {
            pathSum[0] += grid[row][0];
            for (int col = 1; col < width; col++) {
                if (pathSum[col - 1] < pathSum[col])
                    pathSum[col] = pathSum[col - 1] + grid[row][col];
                else
                    pathSum[col] += grid[row][col];
            }
        }
        return pathSum[width - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
