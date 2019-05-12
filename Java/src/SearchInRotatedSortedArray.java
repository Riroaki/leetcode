public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int cut = nums[0], lo = 0, hi = nums.length - 1;
        // find the rotate position.
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] >= cut)
                lo = mi + 1;
            else
                hi = mi;
        }
        // check if the array is truly rotated
        if (nums[lo] > cut)
            lo = 0;
        // if the target is on the left side
        else if (target >= cut) {
            lo = 0;
            hi--;
        // if the target is on the right side
        } else
            hi = nums.length - 1;
        // find target through binary search
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
