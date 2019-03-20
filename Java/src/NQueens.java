public class NQueens {
    private int[] pos;
    private List<List<String>> res;
    private char[] row;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0)
            return new ArrayList<>();
        res = new ArrayList<>();
        row = new char[n];
        pos = new int[n];
        helper(n, 0);
        return res;
    }

    private void helper(int n, int index) {
        if (index == n) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Arrays.fill(curr, '.');
                row[pos[i]] = 'Q';
                curr.add(String.valueOf(row));
            }
            res.add(curr);
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
