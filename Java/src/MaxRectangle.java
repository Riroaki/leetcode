public class MaxRectangle {
    // 这一题放在85，和LargestRectangleInHistogram（84）题放在一起真是太巧妙了
    // 首先，也是用dp做；heights保存某一列从上数第i行的 * * 连续的 * * '1'的个数！
    // 然后使用84的逻辑，取连续区间最大的矩形大小就可以了
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int width = matrix[0].length, res = 0;
        int[] heights = new int[width];
        for (char[] row : matrix) {
            for (int c = 0; c < width; c++) {
                if (row[c] == '1') heights[c]++;
                else heights[c] = 0;
            }
            res = Math.max(res, new LargestRectangleInHistogram().largestRectangleArea(heights));
        }
        return res;
    }
}
