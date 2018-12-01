class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1, len2 = len(nums1), len(nums2)
        totalLen = len1 + len2
        middle = totalLen // 2
        i, j, a, isFound = 0, 0, [0, 0], False
        while i < len1 and j < len2:
            if nums1[i] < nums2[j]:
                a[0] = a[1]
                a[1] = nums1[i]
                i += 1
            else:
                a[0] = a[1]
                a[1] = nums2[j]
                j += 1
            if i + j > middle:
                isFound = True
                break
        if not isFound:
            if i + j == middle:
                a[0], a[1] = a[1], nums1[i] if j >= len2 else nums2[j]
            elif i >= len1:
                a[0], a[1] = nums2[middle - i - 1], nums2[middle - i]
            else:
                a[0], a[1] = nums1[middle - j - 1], nums1[middle - j]
            print('i=%d, j=%d, a=%d %d' % (i, j, a[0], a[1]))
        if totalLen % 2:
            return a[1]
        return (a[0] + a[1]) / 2


if __name__ == '__main__':
    sol = Solution()
    a = [1, 2, 3]
    b = [4, 5, 6]
    print(sol.findMedianSortedArrays(a, b))
    a = [1, 2]
    b = [2.5, 5, 6, 7, 8]
    print(sol.findMedianSortedArrays(a, b))
    a = [1, 2, 3]
    b = [4, 5]
    print(sol.findMedianSortedArrays(a, b))
    a = [2]
    b = [1, 3, 4]
    print(sol.findMedianSortedArrays(a, b))
