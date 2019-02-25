import java.util.Arrays;

public class GridIllumination {
    public int[] gridIlluminationNaive(int N, int[][] lamps, int[][] queries) {
        int m = queries.length, l = lamps.length;
        int[] res = new int[m];
        boolean[] notLit = new boolean[l];
        if (m == 0 || lamps.length == 0) return res;
        for (int i = 0; i < m; i++) {
            int row = queries[i][0], col = queries[i][1];
            for (int j = 0; j < l; j++) {
                if (notLit[j]) continue;
                if (row == lamps[j][0] || col == lamps[j][1]
                        || Math.abs(row - lamps[j][0]) == Math.abs(col - lamps[j][1])) {
                    res[i] = 1;
                    for (int k = 0; k < l; k++) {
                        int[] lamp = lamps[k];
                        if (Math.abs(row - lamp[0]) < 2 && Math.abs(col - lamp[1]) < 2)
                            notLit[k] = true;
                    }
                    break;
                }
            }
        }
        return res;
    }

    // Naive 版本。。。用数组存，存不下啊。。。
    // 本来以为效率会高的一批。呵呵。。
    // 我佛了。这题N最大的时候是10的9次。。。这做法妥妥MLE
    private int[][] grid = new int[10000][10000];

    private void turnOnOffLights(int row, int col, int diff) {
        int N = grid.length;
        for (int i = 0; i < N; i++)
            if (grid[i][col] != Integer.MAX_VALUE) grid[i][col] += diff;
        for (int j = 0; j < N; j++)
            if (grid[row][j] != Integer.MAX_VALUE) grid[row][j] += diff;
        for (int i = 0; i < N; i++) {
            int j = col - row + i;
            if (j < 0 || j >= N) continue;
            if (grid[i][j] != Integer.MAX_VALUE) grid[i][j] += diff;
        }
        for (int i = 0; i < N; i++) {
            int j = j = col + row - i;
            if (j < 0 || j >= N) continue;
            if (grid[i][j] != Integer.MAX_VALUE) grid[i][j] += diff;
        }
        grid[row][col] = diff == 1 ? Integer.MAX_VALUE : 0;
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int m = queries.length, l = lamps.length;
        int[] res = new int[m];
        if (m == 0 || lamps.length == 0) return res;
        for (int[] lamp : lamps) turnOnOffLights(lamp[0], lamp[1], 1);
        for (int i = 0; i < m; i++) {
            int row = queries[i][0], col = queries[i][1];
            res[i] = grid[row][col] > 0 ? 1 : 0;
            for (int ii = row - 1; ii <= row + 1; ii++) {
                if (ii < 0 || ii >= N) continue;
                for (int jj = col - 1; jj <= col + 1; jj++) {
                    if (jj < 0 || jj >= N) continue;
                    if (grid[ii][jj] == Integer.MAX_VALUE)
                        turnOnOffLights(ii, jj, -1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new GridIllumination().gridIllumination(5,
//                new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}})));
        System.out.println(Arrays.toString(new GridIllumination().gridIllumination(5,
                new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}, {1, 1}})));
    }
}
