public class MaxSumOfRectangleNoLargerThanK {
//    // 这里剪枝是对所有数都是非负数的考虑，如果存在负数那么就不剪枝
//    public int maxSumSubmatrixNaive(int[][] matrix, int k) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return 0;
//        int res = 0, h = matrix.length, w = matrix[0].length;
//        int[][] sums = new int[h][w];
//        for (int starti = 0; starti < h; starti++) {
//            for (int startj = 0; startj < w; startj++) {
//                sums[starti][startj] = matrix[starti][startj];
//                if (sums[starti][startj] > k) continue;
//                res = Math.max(res, sums[starti][startj]);
//                // Fill the start row with sums, and break if sum > k.
//                int endj = startj + 1, endi = starti;
//                for (; endj < w; endj++) {
//                    matrix[starti][endj] = sums[starti][endj - 1] + matrix[starti][endj];
//                    if (matrix[starti][endj] > k) break;
//                    res = Math.max(res, matrix[starti][endj]);
//                }
//                for (int i = starti + 1; i < h; i++) {
//                    for (int j = startj; j < endj; j++) {
//                        // If the sum of above line is over than k,
//                        // it's impossible to get a better result for larger lines
//                        sums[i][j] = sums[i - 1][j] + matrix[i][j];
//                        if (sums[i][j] > k) {
//                            endj = j;
//                            break;
//                        }
//                        res = Math.max(res, sums[i][j]);
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        int h = matrix.length, w = matrix[0].length;
        int[][] sums = new int[h][w];
        for (int i1 = 0; i1 < h; i1++) {
            for (int j1 = 0; j1 < w; j1++) {
                sums[i1][j1] = matrix[i1][j1];
                if (sums[i1][j1] <= k) res = Math.max(res, sums[i1][j1]);
                for (int j = j1 + 1; j < w; j++) {
                    sums[i1][j] = sums[i1][j - 1] + matrix[i1][j];
                    if (sums[i1][j] <= k) res = Math.max(res, sums[i1][j]);
                }
                for (int i = i1 + 1; i < h; i++) {
                    sums[i][j1] = sums[i - 1][j1] + matrix[i][j1];
                    if (sums[i][j1] <= k) res = Math.max(res, sums[i][j1]);
                }
                for (int i2 = i1 + 1; i2 < h; i2++) {
                    for (int j2 = j1 + 1; j2 < w; j2++) {
                        sums[i2][j2] = sums[i2 - 1][j2] + sums[i2][j2 - 1] - sums[i2 - 1][j2 - 1] + matrix[i2][j2];
                        if (sums[i2][j2] <= k) res = Math.max(res, sums[i2][j2]);
                    }
                }
                // print the result
//                for (int i = i1; i < h; i++) {
//                    for (int j = j1; j < w; j++) {
//                        System.out.print(sums[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("------");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 0, 1}, {0, -2, 3}};
        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(a, 2));
        int[][] b = new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(b, 10));
        int[][] c = new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(c, 8));
    }
}
