// 这题，我佛了。。因为允许重复元素，感觉搜索切割点怎么都要O（n）复杂度
// 还不如暴搜（试着提交，都是1ms）？？？
public class SearchInRotatedSortedArray2 {
    private boolean exist(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
            else return true;
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int pos = 0;
        if (nums.length == 0) return false;
        // Find the place where the array is rotated.
        while (pos < nums.length - 1 && nums[pos] <= nums[pos + 1]) pos++;
        if (pos == nums.length - 1) return exist(nums, 0, pos, target);
        pos++;// Set the pos to be at the start of second part.
        // Find target using binary search in both sides.
        if (target == nums[0]) return true;
        if (target > nums[0] && pos > 0) return exist(nums, 0, pos - 1, target);
        else return exist(nums, pos, nums.length - 1, target);
    }

    public static void main(String[] args) {
//        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 2));
//        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
//        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{}, 0));
//        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{2}, 0));
//        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{0}, 0));
        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{1, 3}, 3));
        System.out.println(new SearchInRotatedSortedArray2().search(new int[]{1, 1, 3, 1}, 0));
    }
}