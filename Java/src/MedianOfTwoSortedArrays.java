public class MedianOfTwoSortedArrays {
    // O(n1 + n2) sol. Merge the two arrays.
    public double findMedianSortedArraysNaive(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        int[] c = new int[n1 + n2];
        int i1 = 0, i2 =  0, i = 0;
        while (i1 < n1 && i2 < n2) {
            if (a[i1] < b[i2])
                c[i++] = a[i1++];
            else
                c[i++] = b[i2++];
        }
        while (i1 < n1)
            c[i++] = a[i1++];
        while (i2 < n2)
            c[i++] = b[i2++];
        int half = (n1 + n2) / 2;
        if (half % 2 == 1)
            return (double)c[half];
        return (c[half] + c[half - 1]) / 2.0;
    }

    // O(log(min(n1, n2)))
    // recursive.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        if (left == right)
            return (double) findKth(nums1, 0, nums2, 0, left);
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2)
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}
