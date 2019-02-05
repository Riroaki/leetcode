public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 1;
        for (; fast < nums.length; fast++)
            if (nums[fast] != nums[slow]) nums[++slow] = nums[fast];
        slow++;
//        int slow = 1, fast = 1, current = nums[0];
//        for (; fast < nums.length; fast++) {
//            if (nums[fast] != current) {
//                current = nums[fast];
//                nums[slow++] = current;
//            }
//        }
        for (int i = 0; i < slow; i++) System.out.print(nums[i] + " ");
        System.out.println();
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 1, 2}));
    }
}
