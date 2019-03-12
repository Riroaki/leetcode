public class WordBreak {
    // Naive 暴搜,TLE
        // 时间复杂度：应该是m^(s/m_bar)，m_bar表示m个词的平均长度,s/m_bar表示递归层数
    public boolean wordBreakNaive(String s, List<String> words) {
        if (s.length() == 0)
            return true;
        for (String tmp : words)
            if (s.startsWith(tmp) && wordBreakNaive(s.substring(tmp.length()), words))
                return true;
        return false;
    }

    // Better version 1 using dp. 3ms
    // Track whether s[0:i] is satisfied with res[n + 1],
    // where res[i] represents taking first i chars from s.
    // Time complexity: O(n*m), if s is long and dict is small, this one should be better.
    // I did not use a substring of s but used a global char array instead to save time.
    private char[] ch;

    private boolean equal(int from, String str) {
        for (int i = 0; i < str.length(); i++)
            if (ch[from + i] != str.charAt(i))
                return false;
        return true;
    }

    public boolean wordBreak1(String s, List<String> words) {
        int n = s.length();
        ch = s.toCharArray();
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String tmp : words) {
                if (tmp.length() <= i && res[i - tmp.length()]
                    && equals(i - tmp.length(), tmp)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[n];
    }

    // Better version 2.
    // Time complexity: O(n2) ，但是因为有substring所以还会更慢。。。6ms 
    // When s is short this one would be better.
    public boolean wordBreak2(String s, List<String> dict) {
        HashSet<String> words = new HashSet<>(dict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
