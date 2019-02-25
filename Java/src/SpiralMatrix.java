import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // 四个限制器，同时也是下标号，真是绝顶聪明的做法。。。
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0, top = 0;
        while (true) {
            // 右
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if (left > right || top > bottom) break;
            // 下
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;
            // 左
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            // 上
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1}}));
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
