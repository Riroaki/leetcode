import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class WordSearch2Naive {
    // Naive version is to calculate like I've done in word search i.
    // Exhaust all possibilities every time.
//    char[] wordSeq;
//
//    public List<String> findWordsNaive(char[][] board, String[] words) {
//        if (board == null || words == null || words.length == 0) return new ArrayList<>();
//        int h = board.length, w = board[0].length;
//        List<String> res = new ArrayList<>();
//        for (String word : words) {
//            wordSeq = word.toCharArray();
//            for (int i = 0; i < h; i++) {
//                for (int j = 0; j < w; j++) {
//                    if (res.indexOf(word) >= 0) continue;
//                    if (find(board, 0, i, j))
//                        res.add(word);
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean find(char[][] board, int index, int i, int j) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || wordSeq[index] != board[i][j])
//            return false;
//        if (index == wordSeq.length - 1) return true;
//        board[i][j] = '.';
//        boolean res = find(board, index + 1, i + 1, j) || find(board, index + 1, i - 1, j)
//                || find(board, index + 1, i, j + 1) || find(board, index + 1, i, j - 1);
//        board[i][j] = wordSeq[index];
//        return res;
//    }
}
