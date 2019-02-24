class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == '':
            return 0
        maxLen = 1
        substr = s[0]
        for i in range(1, len(s)):
            hasEq = False
            for j in range(len(substr)):
                if substr[j] == s[i]:
                    hasEq = True
                    if len(substr) > maxLen:
                        maxLen = len(substr)
                    substr = substr[j+1:] + s[i]
                    break
            if hasEq is False:
                substr += s[i]
        if len(substr) > maxLen:
            return len(substr)
        return maxLen


if __name__ == '__main__':
    sol = Solution()
    print(sol.lengthOfLongestSubstring('abcabcbb'))
