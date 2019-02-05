public class FindMinRotatedSortedArray2 {
    // 4 conditions:
    // nums[left] <= nums[mid] <= nums[right], min is nums[left]
    // nums[left] > nums[mid] <= nums[right], (left, mid] is not sorted, min is inside
    // nums[left] <= nums[mid] > nums[right], (mid, right] is not sorted, min is inside
    // nums[left] > nums[mid] > nums[right], impossible
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (right == -1) return -1;
        while (left < right - 5) {
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[right]) {
                if (nums[left] >= nums[mid]) right = mid;
                else left = mid + 1;
            } else break;
        }
        int res = nums[left];
        for (left++; left <= right; left++)
            if (nums[left] < res) res = nums[left];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinRotatedSortedArray2().findMin(new int[]{2, 2, 2, 0, 1}));
    }
}
