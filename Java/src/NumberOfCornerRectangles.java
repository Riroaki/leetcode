public class NumberOfCornerRectangles {
    // O(h^2*w)，如果w较小而h较大的时候可以交换!
    // 具体思路：对任意y1 = i, y2 = j, 找到所有的x使mat[x][y1] = mat[x][y2] = 1
    // 这样一来，这些x两两就能够组成矩形。组成的个数 = x * (x - 1) / 2.
    // 遍历所有的y1和y2组合之后，得到解。
    public int countCornerRectangles(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;
        int res = 0, height = mat.length, width = mat[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = i + 1; j < height; j++) {
                int count = 0;
                for (int k = 0; k < width; k++)
                    if (mat[k][i] == 1 && mat[k][j] == 1)
                        count++;
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }

    // Naive version, O(h^2*w*2)
    public int countCornerRectangles(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;
        int res = 0, height = mat.length, width = mat[0].length;
        for (int i1 = 0; i1 < height; i1++) {
            for (int j1 = 0; j1 < width; j1++) {
                for (int i2 = i1 + 1; i2 < height; i2++) {
                    for (int j2 = j1 + 1; j2 < width; j2++) {
                        if (mat[i1][j1] == 1 && mat[i1][j2] == 1 && mat[i2][j1] == 1 && mat[i2][j2] == 1)
                            res++;
                    }
                }
            }
        }
        return res;
    }
}
