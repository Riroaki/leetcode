public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            // Calculate from right to left!
            // Very subtle idea...
            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                maxVal = Math.max(maxVal, a[j]);
                dp[i] = Math.max(dp[i], (j == 0 ? 0 : dp[j - 1]) + (i - j + 1) * maxVal);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
