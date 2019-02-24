public class LongestPalindromicSubstring {
    // Brute force method, O(n3) time complexity
    private boolean isPalindrome(String s, int fromIndex, int toIndex) {
        for (int i = fromIndex, j = toIndex; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }

    public String longestPalindromeBruteForce(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length(), start = 0, maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (isPalindrome(s, i, j) && j - i + 1 > maxLen) {
                    System.out.println(s.substring(start, maxLen));
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, maxLen);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        String res = "";
        boolean[][] len = new boolean[n][n];
        len[0][0] = true;
        for (int i = 1; i < n; i++) {
//            len[0][i] = isPalindrome(s, i);
        }
        for (int i = 2; i < n - 1; i++) {
            len[i][i] = true;
            len[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for (int j = i + 1; j < n; j++) {

            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindromeBruteForce("cbbdadbbc"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeBruteForce("abcdbbfcba"));
    }
}
