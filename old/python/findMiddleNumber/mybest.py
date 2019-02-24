# 处理某个数组末端的地方比较麻烦，实际上不如合并，然后调用内置的sort
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1, len2 = len(nums1), len(nums2)
        totalLen = len1 + len2
        temp, temp1, temp2 = 0, 0, 0
        i, j = 0, 0
        middle = totalLen // 2
        while i < len1 or j < len2:
            if i >= len1:
                temp = nums2[j]
                j += 1
            elif j >= len2:
                temp = nums1[i]
                i += 1
            elif nums1[i] < nums2[j]:
                temp = nums1[i]
                i += 1
            else:
                temp = nums2[j]
                j += 1
            temp2 = temp1
            temp1 = temp
            if i + j > middle:
                break
        if totalLen % 2:
            return temp1
        else:
            return (temp1 + temp2) / 2
