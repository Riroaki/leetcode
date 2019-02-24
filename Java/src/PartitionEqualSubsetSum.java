public class PartitionEqualSubsetSum {
    public boolean canPartitionNaive(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) != 0) return false;
        sum >>= 1;
        boolean[] sumDP = new boolean[sum + 1];
        sumDP[0] = true;
        for (int num : nums) {
            // 这里需要倒过来，避免出现num被重复加n次的后果
            // （比如，第一次加得到dp[i]=true，第二次加就是dp[2*i]=true）
            for (int i = sum-1; i >=0; i--) {
                if (sumDP[i] && i + num <= sum) sumDP[i + num] = true;
            }
            if (sumDP[sum]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartitionNaive(new int[]{1, 5, 11, 5}));
        System.out.println(new PartitionEqualSubsetSum().canPartitionNaive(new int[]{1, 2, 3, 5}));
        System.out.println(new PartitionEqualSubsetSum().canPartitionNaive(new int[]{1, 2, 5}));
    }
}
