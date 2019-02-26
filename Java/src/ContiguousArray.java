public class ContiguousArray {
    public int findMaxLengthNaive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j] == 0 ? -1 : 1;
                if (sum == 0) res = Math.max(res, j - i + 1);
            }
            if (res >= n - i) break;
        }
        return res;
    }
}
