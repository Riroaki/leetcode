public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(currentSum, 0);
        }
        return maxSum;
    }
}
