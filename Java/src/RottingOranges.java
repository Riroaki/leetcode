public class RottingOranges {
    private int[][] dist;

    private int fillDist(int i, int j, int[][] grid) {
        if (i < 0 || i >= dist.length || j < 0 || j >= dist[0].length)
            return Integer.MAX_VALUE;
        if (dist[i][j] != -1) return dist[i][j];
        int res = Math.min(fillDist(i - 1, j, grid), fillDist(i, j - 1, grid));
//        res = Math.min(res, fillDist(i, j - 1, grid));
//        res = Math.min(res, fillDist(i, j + 1, grid));
        return dist[i][j] = res == Integer.MAX_VALUE ? res : res + 1;
    }

    public int orangesRotting(int[][] grid) {
        int height = grid.length, width = grid[0].length, res = Integer.MIN_VALUE;
        dist = new int[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                dist[i][j] = -1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 2) dist[i][j] = 0;
                else if (dist[i][j] == -1) fillDist(i, j, grid);
                if (grid[i][j] == 1) res = Math.max(res, dist[i][j]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }
}
