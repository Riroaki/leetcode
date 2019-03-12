public class ParlindromePartitioning2 {
    public int minCut(String s) {
        if (s == null || s.length == 0)
            return 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[][] valid = new boolean[n][n];
        for (int i = n - 1; i < 0; i++) {
            for (int j = i; j < n; j++) {
                if (valid[i][j] && (j - i < 2 || valid[i + 1][j - 1])
                    valid[i][j] = true;
            }
        }
        // 上面是最长回文字符串的代码；
        // valid保存了从i到j是否是回文的结果
        // 这里就再次使用dp找到一个valid的结果，边界比较微妙，敬请注意
        // 每找到一个valid，就将它的前一个字符的结果+1和当前结果比较，取最小值；边界是从0到当前字符，如果是回文那么当前结果就是0
        // 总体时间复杂度：求所有回文结果是O(n2)，这里又是O(n2)，所以总体是O(n2)
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            if (valid[0][i]) {
                res[i] = 0;
                continue;
            }
            for (int j = 0; j <= i; j++)
                if (valid[j][i])
                    res[i] = Math.min(res[i], res[j - 1] + 1);
        }
        return res[n - 1];
    }
}
