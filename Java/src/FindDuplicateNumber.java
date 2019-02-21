public class FindDuplicateNumber {
    // 最初想法，而且时间复杂度最低，0ms。
    // 用一个数组存，O(n)的时间和空间复杂度
    public int findDuplicateNaive(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int n = nums.length;
        int[] appear = new int[n];
        for (int num : nums) {
            if (++appear[num] == 2) return num;
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int n = nums.length;
        return -1;
    }
}
