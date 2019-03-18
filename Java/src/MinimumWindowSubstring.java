public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n1 < n2)
            return "";
        int[] freq = new int[128], curr = new int[128];
        for (int i = 0; i < n2; i++) {
            freq[t.charAt(i)]++;
            curr[s.charAt(i)]++;
        }
        // 为了避免复杂的边界条件，从n2 - 1开始处理
        curr[s.charAt(n2 - 1)]--;
        int uncovered = 0;
        for (int i = 0; i < 128; i++)
            uncovered += freq[i] > curr[i] ? 1 : 0;
        int minStart = -1, minEnd = n1, start = 0, end = n2 - 1;
        // 思路：当满足窗口内所有的字符数都大于等于t中字符数的时候，左侧指针右移缩小窗口，直到不能再移动
        for (; end < n1; end++) {
            curr[s.charAt(end)]++;
            if (curr[s.charAt(end)] == freq[s.charAt(end)])
                uncovered--;
            // 左侧向右移动，收缩窗口
            if (uncovered == 0) {
                while (curr[s.charAt(start)] > freq[s.charAt(start)]) {
                    curr[s.charAt(start)]--;
                    start++;
                }
                // 只要存在一对end和start使uncovered == 0，那么minStart = -1一定会被更新
                if (end - start < minEnd - minStart) {
                    minEnd = end;
                    minStart = start;
                }
            }
        }
        return minStart == -1 ? "" : s.substring(minStart, minEnd + 1);
    }
}
