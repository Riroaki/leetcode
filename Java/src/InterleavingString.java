public class InterleavingString {
    // Naive version.暴搜
        // 16%
        // 时间复杂度：2^n3
    private char[] ch1, ch2, ch3;
    private int n1, n2, n3;

    private boolean helper(int i1, int i2, int i3) {
        if (i3 == n3)
            return true;
        boolean res1 = false, res2 = false;
        if (i1 < n1)
            res1 = ch1[i1] == ch3[i3] && helper(i1 + 1, i2, i3 + 1);
        if (res1) // 中途剪枝，按理说会快一点
            return true;
        if (i2 < n2)
            res2 = ch2[i2] == ch3[i3] && helper(i1, i2 + 1, i3 + 1);
        return res2;
    }

    public boolean isInterleaveNaive(String s1, String s2, String s3) {
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();
        ch1 = s1.toCharArray();
        ch2 = s2.toCharArray();
        ch3 = s3.toCharArray();
        if (n3 != n1 + n2)
            return false;
        return helper(0, 0, 0);
    }

    // 记忆化dp
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray(), ch3 = s3.toCharArray();
        if (n1 + n2 != n3)
            return false;
        boolean[][] valid = new boolean[n1 + 1][n2 + 1];
        // valid[i][j] means result when we take i chars from s1 and j chars from s2.
        valid[0][0] = true;
        for (int i = 1; i <= n1; i++)
            valid[i][0] = valid[i - 1][0] && ch1[i - 1] == ch3[i - 1];
        for (int j = 1; j <= n2; j++)
            valid[0][j] = valid[0][i - 1] && ch2[j - 1] == ch3[j - 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                valid[i][j] = (valid[i - 1][j] && ch1[i - 1] == ch3[i + j - 1])
                        || (valid[i][j - 1] && ch2[j - 1] == ch3[i + j - 1]);
            }
        }
        return valid[n1][n2];
    }
}
