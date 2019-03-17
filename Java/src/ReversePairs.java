public class ReversePairs {
    // Calculate while merge sorting the numbers:
    // split the nums into 2 parts, left and right.
    // then there will be 3 parts of reverse pairs: within left/right part and between two parts.
    // For the between, if nums[i] > nums[j] * 2 then reverse pairs will add (leftSize - i).
        // (i from left part, j from right part.)

    // Notes that if we nums[j] << 1, we may get overflow.
    // So we choose to let nums[i] >> 1.
    // check (nums[i] >> 1) > nums[j] || ((nums[i] >> 1) == nums[j] && (nums[i] & 1) == 1)
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n);
    }
    
    private int helper(int[] nums, int s, int e) {
        if (e <= s + 1)
            return 0;
        int half = s + (e - s) / 2, res = 0;
        res += helper(nums, s, half) + helper(nums, half, e);
        
        int i = s, j = half, curr;
        while (i < half && j < e) {
            curr = nums[i] >> 1;
            if (curr > nums[j] || (curr == nums[j] && (nums[i] & 1) == 1)) {
                j++;
                res += half - i;
            } else
                i++;
        }
        
        int[] tmp = new int[e - s];
        for (int k = s; k < e; k++)
            tmp[k - s] = nums[k];
        i = s;
        j = half;
        curr = s;
        while (i < half && j < e) {
            if (tmp[i - s] < tmp[j - s])
                nums[curr++] = tmp[i++ - s];
            else
                nums[curr++] = tmp[j++ - s];
        }
        while (i < half)
            nums[curr++] = tmp[i++ - s];
        while (j < half)
            nums[curr++] = tmp[j++ - s];
        return res;
    }
}
