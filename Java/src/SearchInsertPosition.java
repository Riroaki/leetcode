public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] < target)
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
