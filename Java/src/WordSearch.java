public class WordSearch {
    // 我的天哪第一次简单写写就100%了，开心
    char[] wordSeq;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        wordSeq = word.toCharArray();
        int h = board.length, w = board[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (find(board, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean find(char[][] board, int index, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (wordSeq[index] != board[i][j]) return false;
        // 字符匹配，那么将这个字符先修改表示已经经过这里，之后再改回来
        board[i][j] = '.';
        if (index == wordSeq.length - 1) return true;
        index++;
        boolean res = find(board, index, i + 1, j) || find(board, index, i - 1, j)
                || find(board, index, i, j + 1) || find(board, index, i, j - 1);
        board[i][j] = wordSeq[index - 1];
        return res;
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(a, "ABCCED"));
        System.out.println(new WordSearch().exist(a, "SEE"));
        System.out.println(new WordSearch().exist(a, "ABCB"));
    }
}
