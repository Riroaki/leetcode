public class MinimumSizeSubarraySum {
    public int minSubArrayLenNaive(int s, int[] nums) {
        int n = nums.length, res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
            if (sum < s)
                break;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 我傻了，这不就是简单的滑动窗口嘛...2ms 99%
    public int minSubarrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0, start = 0, end = 0, n = nums.length;
        for (; end < n; end++) {
            sum += nums[end];
            while (sum - nums[start] > s)
                sum -= nums[start++];
            if (sum >= s)
                res = Math.min(res, end - start + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
