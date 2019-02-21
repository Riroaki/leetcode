public class LongestIncreasingSubsequence {
    public int lengthOfLISNaive(int[] nums) {
        int n = nums.length, res = 1;
        if (n < 2) return n;
        int[] dp = new int[n];
        // dp[i] means the longest length of sub-sequence ending with nums[i].
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) dp[i] = 1;
            res = Math.max(res, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length, res = 1, endIndex = 1;
        if (n < 2) return n;
        // dp[i] means the longest length of sub-sequence ending with nums[i].
        int[] dp = new int[n], ends = new int[n];
        dp[0] = 1;
        ends[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int low = 0, high = endIndex;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[i] > ends[mid]) low = mid + 1;
                else high = mid;
            }
            endIndex = Math.max(endIndex, low);
            ends[low] = nums[i];
            dp[i] = low + 1;
        }
        return endIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
