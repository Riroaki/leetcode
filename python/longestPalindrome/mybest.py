# 废弃不用的算法：还是很慢很麻烦
class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2:
            return s
        maxSub = [0, 0]
        maxLen = 1
        length = len(s)
        result = [[0 for _ in range(length)] for _ in range(length)]
        for i in range(length):
            result[i][i] = 1
        for i in range(length - 1):
            if s[i] == s[i + 1]:
                result[i][i + 1] = 2
                maxSub = [i, i + 1]
                maxLen = 2
        for i in range(length):
            if result[i][i] == 0:
                continue
            j = 1
            while i - j >= 0 and i + j < length and s[i] == s[i + j]:
                result[i - j][i + j] = result[i - j + 1][i + j - 1] + 2
                if result[i - j][i + j] > maxLen:
                    maxLen = result[i - j][i + j]
                    maxSub = [i, i + j]
                j += 1
        for line in result:
            print(line)
        print(maxSub)
        for i in range(length - 1):
            if result[i][i + 1] == 0:
                continue
            j = 1
            while i + 1 - j >= 0 and i + 1 + j < length and s[i] == s[i + j]:
                result[i + 1 - j][i + 1 + j] = result[i + 2 - j][i + j] + 2
                if result[i + 1 - j][i + 1 + j] > maxLen:
                    maxLen = result[i + 1 - j][i + 1 + j]
                    maxSub = [i + 1, i + 1 + j]
                j += 1
        for line in result:
            print(line)
        return s[maxSub[0]:maxSub[1] + 1]


if __name__ == '__main__':
    sol = Solution()
    print(sol.longestPalindrome('ccccc'))
