public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) if (nums[fast] != val) nums[slow++] = nums[fast];
//        for (int i = 0; i < slow; i++) System.out.print(nums[i] + " ");
//        System.out.println();
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
