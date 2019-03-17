public class ShortestUnsortedContinuousSubarray {
    // Naive sol. O(n log n) time and O(n) space
        // after sorting, find the first different index and last different index.
    public int findUnsortedSubarray1(int[] nums) {
        int[] origin = nums.clone();
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        for (; start < end; start++)
            if (nums[start] != origin[start])
                break;
        for (; end >= 0; end--)
            if (nums[end] != origin[end])
                break;
        return end - start < 0 ? 0 : end - start + 1;
    }

    // Naive sol. O(n) time and space
    // small right means smallest value of nums[i:], large left means largest value of nums[:i]
    // find the first index where there is smaller value at its right, and last index where there is larger value at its left
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2)
            return 0;
        int n = nums.length;
        int[] smallRight = new int[n], largeLeft = new int[n];
        smallRight[n - 1] = nums[n - 1];
        largeLeft[0] = nums[0];
        for (int i = n - 2; i >= 0; i--)
            smallRight[i] = Math.min(smallRight[i + 1], nums[i]);
        for (int i = 1; i < n; i++)
            largeLeft[i] = Math.max(largeLeft[i - 1], nums[i]);
        int start = 0, end = n - 1;
        for (; start < n - 1; start++)
            if (smallRight[start + 1] < nums[start])
                break;
        for (; end > 0; end--)
            if (largeLeft[end - 1] > nums[end])
                break;
        return end < start ? 0 : end - start + 1;
    }
}
