class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2:
            return s
        maxSub = [0, 0]
        length = len(s)
        result = [[0 for _ in range(length)] for _ in range(length)]
        for i in range(length):
            result[i][i] = 1
        for i in range(length - 1):
            if s[i] == s[i + 1]:
                result[i][i + 1] = 2
                maxSub = [i, i + 1]
        for i in range(2, length):
            for j in range(length - i):
                if s[i + j] == s[j] and result[j + 1][j + i - 1]:
                    # print('i=%d,j=%d' % (i, j))
                    result[j][j + i] = result[j + 1][j + i - 1] + 2
                    maxSub = [j, j + i]
        # print(result)
        return s[maxSub[0]:maxSub[1] + 1]


if __name__ == '__main__':
    sol = Solution()
    print(sol.longestPalindrome('ccccc'))
