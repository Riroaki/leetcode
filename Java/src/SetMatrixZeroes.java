import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean fillFirstColToZero = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
                fillFirstColToZero = true;
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++)
            if (matrix[row][0] == 0)
                Arrays.fill(matrix[row], 0);
        for (int col = 1; col < matrix[0].length; col++)
            if (matrix[0][col] == 0)
                for (int row = 0; row < matrix.length; row++)
                    if(matrix[row][col] != 0)
                        matrix[row][col] = 0;
        if (matrix[0][0] == 0)
            Arrays.fill(matrix[0], 0);
        if (fillFirstColToZero)
            for (int row = 0; row < matrix.length; row++)
                matrix[row][0] = 0;
    }

    private static void printMat(int[][] m) {
        for (int[] ints : m) {
            for (int j = 0; j < m[0].length; j++)
                System.out.print(ints[j] + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] tmp = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetMatrixZeroes().setZeroes(tmp);
        printMat(tmp);
    }
}
