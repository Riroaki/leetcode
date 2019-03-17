public class CountOfRangeSum {
    // Naive O(n^2) sol.
    public int countRangeSum(int[] nums, int lo, int hi) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;// 重要陷阱之一，溢出
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= lo && sum <= hi)
                    res++;
            }
        }
        return res;
    }

    // better sol.

}
