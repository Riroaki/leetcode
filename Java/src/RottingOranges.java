public class RottingOranges {
    private int[][] dist;

    private boolean[][] visited;

    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int height = grid.length, width = grid[0].length, res = 0;
        dist = new int[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                // 这里有个不会烂的橘子
//                if (findDist(i, j, grid) == -1 && grid[i][j] == 1) return -1;
//                res = Math.max(res, dist[i][j]);
//                System.out.print(dist[i][j] + " ");
//            }
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }
}
