public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] < target)
                col++;
            else if (matrix[row][col] > target)
                row--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Search2DMatrix().searchMatrix(new int[][]
                {{1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 3));
        System.out.println(new Search2DMatrix().searchMatrix(new int[][]
                {{1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}}, 13));
    }
}
