public class NQueens2 {
    private int[] pos;
    private int res;
    
    public int totalNQueens(int n) {
        res = 0;
        pos = new int[n];
        helper(n, 0);
        return res;
    }
    
    private void helper(int n, int index) {
        if (index == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < index; j++) {
                if (pos[j] == i || pos[j] - i == j - index || pos[j] - i == index - j) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                pos[index] = i;
                helper(n, index + 1);
            }
        }
    }
}
