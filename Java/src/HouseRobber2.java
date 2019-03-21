public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }
    
    private int helper(int[] nums, int from, int to) {
        int r = 0, nr = 0;
        for (int i = from; i < to; i++) {
            int tmp = nr;
            nr = Math.max(nr, r);
            r = tmp + nums[i];
        }
        return Math.max(nr, r);
    }
} 
