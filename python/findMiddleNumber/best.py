class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l1 = len(nums1)
        l2 = len(nums2)
        myl = int(l1 + l2)

        nums = nums1 + nums2
        nums.sort()

        if (myl % 2) == 0:
            out = (nums[int(myl/2)] + nums[int((myl / 2) - 1)]) / 2
        else:
            out = nums[int((myl - 1) / 2)]
        return out
