public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        String res = "";
        boolean[][] len = new boolean[n][n];
        len[0][0] = true;
        for (int i = 1; i < n; i++) {
            len[0][i] = isPalindrome(s, i);
        }
        for (int i = 2; i < n - 1; i++) {
            len[i][i] = true;
            len[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for (int j = i + 1; j < n; j++) {
//                len[i][j] = len[]
            }
        }
        return "";
    }

    private boolean isPalindrome(String s, int toIndex) {
        for (int i = 0, j = toIndex; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}
