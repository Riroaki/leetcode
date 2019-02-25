import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland {
    // 12ms 96%
    // 染色法，第一步将所有的岛屿染上某一种特有的颜色，这样不同岛屿的颜色区分；
    // 第二步将所有单个格子连接的岛屿面积计算出来并选出最大的
    // The painting function: paint the colors of islands, and return the size of it.
    private int paint(int i, int j, int color, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = color;
        return 1 + paint(i + 1, j, color, grid) + paint(i - 1, j, color, grid)
                + paint(i, j + 1, color, grid) + paint(i, j - 1, color, grid);
    }

    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> colorSize = new HashMap<>();
        // 第一种颜色0和第二种颜色1序号已经被使用，所以从2开始
        colorSize.put(0, 0);
        int color = 2, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int size = paint(i, j, color, grid);
                    colorSize.put(color, size);
                    color++;
                }
            }
        }
        // 如果全部都是0，那么不会出现颜色为2的岛，所以面积是1
        if (!colorSize.containsKey(2)) return 1;
        int res = 0;
        boolean noZero = true;
        // 如果全都是1，那么面积是n*m
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int connectedSize = 1;
                    // 用hash set存四个边的颜色序号，去重
                    HashSet<Integer> islands = new HashSet<>();
                    islands.add(i > 0 ? grid[i - 1][j] : 0);
                    islands.add(i < n - 1 ? grid[i + 1][j] : 0);
                    islands.add(j > 0 ? grid[i][j - 1] : 0);
                    islands.add(j < m - 1 ? grid[i][j + 1] : 0);
                    for (int island : islands)
                        connectedSize += colorSize.get(island);
                    res = Math.max(res, connectedSize);
                    noZero = false;
                }
            }
        }
        return noZero ? n * m : res;
    }

    public static void main(String[] args) {
        System.out.println(new MakingALargeIsland().largestIsland(new int[][]{{1, 0}, {0, 1}}));
    }
}
