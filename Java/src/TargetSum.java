import java.util.Arrays;

public class TargetSum {
    //1, Naive method: brute-force recursive with O(2^n) time complexity and O(1) space complexity.
    private int helper(int[] nums, int current, int sum, int target) {
        if (current == nums.length) return sum == target ? 1 : 0;
        return helper(nums, current + 1, sum + nums[current], target)
                + helper(nums, current + 1, sum - nums[current], target);
    }

    public int findTargetSumWaysNaive(int[] nums, int S) {
        // if(nums == null) return 0;
        return helper(nums, 0, 0, S);
    }

    // 2, Improve with memorization, 8ms
    // 这里记忆的是到第i位位置所有和的可能情况，而不是选择了某种情况之后的和是多少；
    // mem表示，到第i位，和为j的时候，接下来有几条路可以通向和为S的情况
    // 这里的2*total+1和total，表示从-total到total的可能性，如果和是负数，那么就是在0-total之间；否则在total-2*total之间
    // 题目保证所有元素的和不大于1000，当然也可以自己求和来做一下空间优化
    // 时间复杂度为O(n*S)，因为每个mem的格子只会被填充一次，可能的填充次数最大就是n*S，空间复杂度也是O(n*S)
    public int findTargetSumWaysMem(int[] nums, int S) {
        int total = 0, n = nums.length;
        for (int num : nums)
            total += num;
        if (S > total || S < -total || n == 0)
            return 0;
        int[][] mem = new int[n][(total << 1) + 1];
        mem[0][total + nums[0]]++;
        mem[0][total - nums[0]]++;
        for (int i = 1; i < n; i++) {
            for (int j = 0, bound = (total << 1) + 1; j < bound; j++) {
                if (mem[i - 1][j] == 0)
                    continue;
                mem[i][j - nums[i]] += mem[i - 1][j];
                mem[i][j + nums[i]] += mem[i - 1][j];
            }
        }
        return mem[n - 1][S + total];
    }

    // 3, dp
    // 思考一下，如果将target和所有数字的总和相加，不就变成所有取加号的数字翻倍，不取加号的数字不参与运算了嘛？
    // 然后再将这个和/2就变成了一倍，问题就等价于在所有数字里面取部分数，使它们的和等于这个(sum+S)>>1
    // 这里还可以剪枝进行优化，对不可能取到的值排除在外，包括S比总和大或者S比总和的负数小，或者S和sum的和不是偶数
    // 时间复杂度为O(n) + O(n*S) = O(n*S)，空间复杂度为O(max(S, sum))
    private int helper3(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public int findTargetSumWaysDP(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (S > sum || S + sum < 0) return 0;
        return ((S + sum) & 1) == 0 ? helper3(nums, (S + sum) >> 1) : 0;
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWaysDP(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new TargetSum().findTargetSumWaysDP(new int[]{1, 2, 3, 4, 5}, 15));
    }
}
