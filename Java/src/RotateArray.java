import java.util.Arrays;

public class RotateArray {
    // 依然是从别人看来的解法，十分巧妙啊
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k <= 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(a, 1);
        System.out.println(Arrays.toString(a));
        new RotateArray().rotate(a, 2);
        System.out.println(Arrays.toString(a));
        new RotateArray().rotate(a, 3);
        System.out.println(Arrays.toString(a));
        new RotateArray().rotate(a, 6);
        System.out.println(Arrays.toString(a));
    }
}
