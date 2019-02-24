import java.util.Arrays;

class MergeSortRecursive {
    private int[] tmp;

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        tmp = new int[nums.length];
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int start, int end) {
        if (start >= end) return;
        int len = end - start, mid = (len >>> 1) + start;
        int start1 = start, start2 = mid + 1;
        helper(nums, start1, mid);
        helper(nums, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end)
            tmp[k++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
        while (start1 <= mid) tmp[k++] = nums[start1++];
        while (start2 <= end) tmp[k++] = nums[start2++];
        if (end + 1 - start >= 0) System.arraycopy(tmp, start, nums, start, end + 1 - start);
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 2, 1, 3};
        new MergeSortRecursive().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}

class MergeSortIterative {
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int seg, start, n = nums.length;
        int[] tmp = new int[nums.length];
        for (seg = 1; seg < n; seg <<= 1) {
            for (start = 0; start < n; start += seg * 2) {
                int mi = start + seg > n ? n : start + seg,
                        hi = start + seg * 2 > n ? n : start + seg * 2;
                int k = start, start1 = start, start2 = mi;
                while (start1 < mi && start2 < hi)
                    tmp[k++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
                while (start1 < mi) tmp[k++] = nums[start1++];
                while (start2 < hi) tmp[k++] = nums[start2++];
                if (hi - start >= 0) System.arraycopy(tmp, start, nums, start, hi - start);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 2, 1, 3};
        new MergeSortIterative().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}