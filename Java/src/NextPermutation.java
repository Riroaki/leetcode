import java.util.Arrays;

public class NextPermutation {
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void reverse(int[] nums, int from, int to) {
        for (int i = from, j = to - 1; i < j; i++, j--) swap(nums, i, j);
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length, iter, last = n - 2;
        while (last >= 0 && nums[last] >= nums[last + 1])
            last--;
        if (last >= 0) {
            int minBigger = last + 1;
            while (minBigger < n - 1 && nums[minBigger + 1] > nums[last])
                minBigger++;
            swap(nums, last, minBigger);
        }
        reverse(nums, last + 1, n);
    }

    static public int fact(int n) {
        int res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 5};
        for (int i = 0; i < fact(a.length); i++) {
            new NextPermutation().nextPermutation(a);
            System.out.println(Arrays.toString(a));
        }

        int[] b = {1, 2, 3, 4};
        for (int i = 0; i < fact(b.length); i++) {
            new NextPermutation().nextPermutation(b);
            System.out.println(Arrays.toString(b));
        }
    }
}
