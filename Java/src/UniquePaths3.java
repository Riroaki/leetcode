public class UniquePaths3 {
    // dfs with backtracking.
    // 3ms 50%
    // 使用mark，令grid[i][j] = 3作为访问过的标记
    // 使用total记录所有可以到达的格子数（不包括end，因为end需要重复使用）
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int h, w;

    public int uniquePathsIII(int[][] grid) {
        h = grid.length;
        if (h == 0)
            return 0;
        w = grid[0].length;
        int total = 0;
        int[] start = new int[2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1)
                    start = new int[]{i, j};
                else if (grid[i][j] == -1)
                    continue;
                total++;
            }
        }
        total--;// 去掉终点
        return dfs(start, grid, total, 0);
    }
    
    private int dfs(int[] now, int[][] grid, int total, int curr) {
        if (now[0] < 0 || now[0] >= h || now[1] < 0 || now[1] >= w)
            return 0;
        int value = grid[now[0]][now[1]];
        if (value == -1 || value == 3)
            return 0;
        if (value == 2 && curr == total)
            return 1;
        grid[now[0]][now[1]] = 3;// Mark (i, j) to be visited.
        int res = 0;
        int[] tmp = new int[2];
        for (int dir = 0; dir < 4; dir++) {
            tmp[0] = now[0] + dirs[dir][0];
            tmp[1] = now[1] + dirs[dir][1];
            res += dfs(tmp, grid, total, curr + 1);
        }
        grid[now[0]][now[1]] = value;// Recover original value.
        return res;
    }
}
