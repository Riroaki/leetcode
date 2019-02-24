public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int pos = 0, left = 0, right = nums.length - 1;
        while (left <= right) {
            pos = left + (right - left) / 2;
            if (nums[pos] == target)
                return pos;
            if (nums[pos] < target)
                left = pos + 1;
            else
                right = pos - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
