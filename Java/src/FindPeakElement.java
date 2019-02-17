public class FindPeakElement {
    // 最简单的O(n)算法，一直比较直到出现peak（即出现右邻居更大的情况）
    public int findPeakElementNaive(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = 0, n = nums.length;
        while (res < n - 1 && nums[res] < nums[res + 1]) res++;
        return res;
    }

    // 二分的解法。这个需要一点思考
    // 首先题目条件不会出现两个相邻数相等，而且保证存在peak
    // 每次比较的时候，中间的数如果比它右边大，左侧一定有解（可能就是mid，也可能在前面，看一直递增区间的末尾），右侧未必有解（比如右侧是递减的）；
    // 中间的数如果比右边小，那么这个数可能不可能是一个peak。这个时候，左边未必有解（比如左侧是递增的），但是右边一定有解（看右边一直递增区间的末尾）。
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
