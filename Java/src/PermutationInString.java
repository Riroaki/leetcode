public class PermutationInString {
    // 66ms, 23%
    // time complexity: O(n1 + n1 * (n2 - n1))
    public boolean checkInclusionNaive(String s1, String s2) {
        int n1 = s1.length(), n2  = s2.length();
        if (n1 > n2)
            return false;
        int[] freq = new int[26], tmp = new int[26];
        for (char ch : s1.toCharArray())
            freq[ch - 'a']++;
        for (int start = 0; start <= n2 - n1; start++) {
            if (freq[s2.charAt(start) - 'a'] <= 0)
                continue;
            for (int i = 0; i < 26; i++)
                tmp[i] = freq[i];
            boolean valid = true;
            for (int i = 0; i < n1; i++) {
                int index = s2.charAt(start + i) - 'a';
                if (tmp[index] <= 0) {
                    valid = false;
                    break;
                }
                tmp[index]--;
            }
            if (valid)
                return true;
        }
        return false;
    }

    // Optimal sliding window.
    // time complexity: O(n1 * 2 + n2 - n1) = O(n1 + n2)
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2)
            return false;
        int start = 0, end = n1 - 1;
        int[] freq = new int[26], tmp = new int[26];
        for (int i = start; i <= end; i++) {
            freq[s1.charAt(i) - 'a']++;
            tmp[s2.charAt(i) - 'a']++;
        }
        int diff = 0;// means count of characters with different frequencies.
        for (int i = 0; i < 26; i++)
            diff += freq[i] == tmp[i] ? 0 : 1;
        for (end++; end < n2; end++, start++) {
            if (diff == 0)
                return true;
            int si = s2.charAt(start) - 'a', ei = s2.charAt(end) - 'a';
            tmp[si]--;// 更新头部；务必记住，不能同时更新si和ei所在的值，因为一旦si==ei，if和else将会被计算两次
            if (tmp[si] == freq[si])
                diff--;
            else if (tmp[si] + 1 == freq[si])
                diff++;
            tmp[ei]++;// 更新尾部；
            if (tmp[ei] == freq[ei])
                diff--;
            else if (tmp[ei] - 1 == freq[ei])
                diff++;
        }
        return diff == 0;
    }
}
