// Easy and clear.
public class RemoveDuplicatesFromSortedArray2 {
    // Genius word from discussions.
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    // My version 6 ms, faster than 98.01% of Java
    public int removeDuplicatesNaive(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int curr = 1;
        boolean isDup = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && !isDup) {
                isDup = true;
                nums[curr++] = nums[i];
            } else if (nums[i] != nums[i - 1]) {
                isDup = false;
                nums[curr++] = nums[i];
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(new int[]{1, 1, 1, 1, 1, 2, 3}));
        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
