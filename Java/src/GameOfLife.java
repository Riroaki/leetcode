public class GameOfLife {
    // 就地做法。只需要把倒数第二位用于存储下一次的状态就可以了
        // 比如，01 -> 11 = 3，只需在原基础+2
        // 恢复的时候，全体右移操作就可以
    public void gameOfLife(int[][] board) {
        int height = board.length, width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isAlive = (board[i][j] & 1) == 1;
                int count = 0;
                for (int ii = i - 1; ii <= i + 1; ii++) {
                    for (int jj = j - 1; jj <= j + 1; jj++) {
                        if (ii < 0 || ii >= height || jj < 0 || jj >= width)
                            continue;
                        if (ii == i && jj == j)
                            continue;
                        count += board[ii][jj] & 1;
                    }
                }
                if (isAlive) {
                    if (count == 2 || count == 3)
                        board[i][j] += 2;
                } else if (count == 3)
                    board[i][j] += 2;
            }
        }
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                board[i][j] >>>= 1;
    }
}
