public class UniquePaths {
    // Naive. O(mn) in both time and space.
    public int uniquePathsNaive(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 1; i < m; i++)
            res[i][0] = 1;
        for (int j = 1; j < n; j++)
            res[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                res[i][j] = res[i - 1][j] + res[i][j - 1];
        return res[m - 1][n - 1];
    }

    // better in space.
    public int uniquePaths(int m, int n) {
        int[] res = new int[m];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                res[j] += res[j - 1];
        return res[m - 1];
    }
}
