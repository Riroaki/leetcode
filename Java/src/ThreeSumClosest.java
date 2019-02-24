import java.util.Arrays;

import static java.lang.Math.abs;

public class ThreeSumClosest {
    // 双指针法，如果遇到刚好相等就直接返回0。当然可以改写成2sumClosest+3sum的组合形式，不容易出错。
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int res = 0, diff = Integer.MAX_VALUE, left;
        for (left = 0; left < nums.length - 2; left++) {
            int right = nums.length - 1;
            int middle = left + 1;
            while (middle < right) {
                int current = nums[left] + nums[right] + nums[middle];
                if (current == target)
                    return target;
                else if (abs(current - target) < diff) {
                    diff = abs(current - target);
                    res = current;
                }
                if (current < target)
                    middle++;
                else
                    right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
