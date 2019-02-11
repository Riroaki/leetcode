import java.util.Arrays;

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

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLISNaive(new int[]{10, 9, 2, 5, 3, 4}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLISNaive(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
