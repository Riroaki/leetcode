# 其实不一定是最优解，最优解有运气成分在；每次的时间是存在一定波动的。
class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        sub = ''
        sub_len = 0
        max_len = 0
        for letter in s:
            if letter in sub:
                if sub_len > max_len:
                    max_len = sub_len
                index = sub.index(letter)
                sub = sub[index + 1:] + letter
                sub_len = sub_len - index
            else:
                sub = sub + letter
                sub_len += 1
        if sub_len > max_len:
            max_len = sub_len
        return max_len
