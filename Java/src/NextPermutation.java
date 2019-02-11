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
        int n = nums.length, iter, last = n - 1;
        if (n < 2) return;
        while (last > 0 && nums[last] == nums[last - 1]) last--;
        if (last == 0) return;// 数字全部相等
        // Compare last two elements.
        // 如果最后两位中，后一位比较大（正序排列），那么交换两者次序即可
        if (nums[last] > nums[last - 1]) {
            swap(nums, last, last - 1);
            // 如果最后两位中，前一位较大（逆序排列），那么继续向前找到非逆序排列的值，并且找到比这个值大的数进行交换，然后对后面进行排列
        } else if (nums[last] < nums[last - 1]) {
            iter = last - 2;
            while (iter >= 0 && nums[iter] >= nums[iter + 1]) iter--;
            // 如果一直到开头都是逆序
            if (iter == -1) {
                reverse(nums, 0, n);
            } else {
                // 找到第一个大于nums[iter]的数并替换掉iter，然后对后面进行逆转
                int min = n - 1;
                for (; min > iter && nums[min] <= nums[iter]; ) min--;
                swap(nums, iter, min);
                reverse(nums, iter + 1, n);
            }
        }
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
