public class MergeSortedArray {
    public void mergeNaive(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, current = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) res[current++] = nums1[i++];
            else res[current++] = nums2[j++];
        }
        if (i < m) {
            for (int k = i; k < m; k++) res[current++] = nums1[k];
        }
        if (j < n) {
            for (int k = j; k < n; k++) res[current++] = nums2[k];
        }
        if (current >= 0) System.arraycopy(res, 0, nums1, 0, current);
    }

    // Brilliant solution!
    // 需要注意的是从后往前赋值，取比较的大的值
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, end = m + n - 1;
        while (i >= 0 && j >= 0) nums1[end--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        while (j >= 0) nums1[end--] = nums2[j--];
    }
}
