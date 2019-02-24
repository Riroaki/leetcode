public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length < 8 || board[0].length < 8) return -1;
        int res = 0, i = 0, j = 0;
        for (; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if (board[i][j] == 'R') break;
            }
            if (j < 8) break;
        }
        for (int x = i + 1; x < 8; x++) {
            if (board[x][j] == 'p') {
                res++;
                break;
            }
            else if (board[x][j] == 'B') break;
        }
        for (int x = i - 1; x >= 0; x--) {
            if (board[x][j] == 'p') {
                res++;
                break;
            }
            else if (board[x][j] == 'B') break;
        }
        for (int y = j + 1; y < 8; y++) {
            if (board[i][y] == 'p') {
                res++;
                break;
            }
            else if (board[i][y] == 'B') break;
        }
        for (int y = j - 1; y >= 0; y--) {
            if (board[i][y] == 'p'){
                res++;
                break;
            }
            else if (board[i][y] == 'B') break;
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(new AvailableCapturesForRook().numRookCaptures(board));
        char[][] board2 = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(new AvailableCapturesForRook().numRookCaptures(board2));
        // [".",".",".",".",".",".",".","."],
        // [".",".",".","p",".",".",".","."],
        // [".",".",".","p",".",".",".","."],
        // ["p","p",".","R",".","p","B","."],
        // [".",".",".",".",".",".",".","."],
        // [".",".",".","B",".",".",".","."],
        // [".",".",".","p",".",".",".","."],
        // [".",".",".",".",".",".",".","."]]
    }
}
