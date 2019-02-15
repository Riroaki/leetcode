import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[10], col = new int[10], grid = new int[10];
        for (int i = 0; i < 9; i++) {
            // 分批验证9行，9列以及九宫格块
            Arrays.fill(row, 0);
            Arrays.fill(col, 0);
            Arrays.fill(grid, 0);
            int tmpRowStart = i - i % 3;
            int tmpColStart = i % 3 * 3;
            for (int j = 0; j < 9; j++) {
                // 验证第i行
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '0'] != 0) return false;
                    row[board[i][j] - '0'] = 1;
                }
                // 验证第i列
                if (board[j][i] != '.') {
                    if (col[board[j][i] - '0'] != 0) return false;
                    col[board[j][i] - '0'] = 1;
                }
//                System.out.println(tmpRowStart + j / 3 + " " + (tmpColStart + j % 3));
                // 验证第i个九宫格
                if (board[tmpRowStart + j / 3][tmpColStart + j % 3] != '.') {
                    if (grid[board[tmpRowStart + j / 3][tmpColStart + j % 3] - '0'] != 0) return false;
                    grid[board[tmpRowStart + j / 3][tmpColStart + j % 3] - '0'] = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}
