public class DistinctSubsequences {
    // dp method. 5ms 72%
    // could be reduced to O(n1) by recording two rows: former records and current records.
    public int numDistinct(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n1 < n2)
            return 0;
        int[][] dp = new int[n2 + 1][n1 + 1];
        // dp[i][j] means counts of distinct subsequence
        // of t[0 : i - 1] in s[0 : j - 1]
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n2; ++i) {
            dp[i + 1][i] = 0;
            char curr = t.charAt(i);
            for (int j = i; j < n1; ++j) {
                // if s[j] != t[i], dp[i + 1][j + 1] = dp[i + 1][j]
                // else dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j]
                dp[i + 1][j + 1] = dp[i + 1][j];
                if (s.charAt(j) == curr)
                    dp[i + 1][j + 1] += dp[i][j];
            }
        }
        return dp[n2][n1];
    }
}
