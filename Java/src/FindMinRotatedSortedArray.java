// 元素不重复版本
public class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (right == -1) return -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[right]) {
                if (nums[mid] >= nums[left]) left = mid + 1;
                else right = mid;
            } else break;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinRotatedSortedArray().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new FindMinRotatedSortedArray().findMin(new int[]{5, 4}));
        System.out.println(new FindMinRotatedSortedArray().findMin(new int[]{4}));
    }
}
