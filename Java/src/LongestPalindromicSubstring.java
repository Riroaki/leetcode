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

    // 从内部向外拓展，
    // 分别检查奇数和偶数长度的子串，O(n2)时间复杂度，空间复杂度是O(1)，当然这里用一个数组存字符串，所以是O(n)
    // 注意边界条件！！！
    // 有一些坑的。。注意java的位运算必须加括号，优先级很低！
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int max = 0, n = s.length(), start = 0, end = 0, currLen;
        char[] ss = s.toCharArray();
        // 奇数长
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; i - j >= 0 && i + j < n; j++) {
                if (ss[i - j] != ss[i + j])
                    break;
            }
            j--;
            currLen = (j << 1) + 1;
            if (currLen > max) {
                max = currLen;
                start = i - j;
                end = i + j;
            }
        }
        // 偶数长
        for (int i = 0; i < n - 1; i++) {
            int j = i, k = i + 1;
            for (; j >= 0 && k < n; j--, k++) {
                if (ss[j] != ss[k])
                    break;
            }
            j++;
            k--;
            if (j >= k)
                continue;
            currLen = k - j + 1;
            if (currLen > max) {
                max = currLen;
                start = j;
                end = k;
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0)
            return "";
        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindromeBruteForce("cbbdadbbc"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeBruteForce("abcdbbfcba"));
    }
}
