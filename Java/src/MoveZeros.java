public class MoveZeros {
    // swap.
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;
        while (fast < n) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast] = tmp;
            }
            fast++;
        }
    }
    // 2 ptrs
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;
        while (fast < n) {
            if (nums[fast] != 0)
                nums[slow++] = nums[fast];
            fast++;
        }
        while (slow < n) {
            nums[slow++] = 0;
        }
    }
}
