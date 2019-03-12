public class SurroundedRegions {
    // 这tm也算medium？？太简单了吧。。。一个bfs将边界的所有O区块变成另外的符号
        // 剩下来的O全部变成X，再把原来的O翻转回来
    private void color(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        if (board[row][col] != 'O')
            return;
        board[row][col] = '.';
        color(board, row + 1, col);
        color(board, row - 1, col);
        color(board, row, col + 1);
        color(board, row, col - 1);
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int height = board.length, width = board[0].length;
        for (int i = 0; i < height; i++) {
            color(board, i, 0);
            color(board, i, width - 1);
        }
        for (int i = 0; i < width; i++) {
            color(board, 0, i);
            color(board, height - 1, i);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
        }
    }
}
