import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // n2思路，使用dp，每次都要遍历前面的最大值
    public int lengthOfLISNaive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // n lgn思路，记录当前最长LIS，并进行二分查找，更新或者插入元素（在指定位置填入新的数字，更新后必然使队伍更优）
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, index = 0;
        int[] tails = new int[n];
        for (int num : nums) {
            int tmp = Arrays.binarySearch(tails, 0, index, num);
            if (tmp < 0){
                tmp = -tmp - 1;// 找不到的话填入在新位置，注意是lower bound+1取负
                tails[tmp] = num;
            }
            if (tmp == index) index++;// 更新LIS长度
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
