public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int n : nums)
            res ^= n;
        return res;
    }
}
