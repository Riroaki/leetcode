public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] < target)
                lo = mi + 1;
            else
                hi = mi;
        }
        return nums[lo] == target ? lo : -1;
    }
}
