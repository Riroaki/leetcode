import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElementNaive(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int count = 0, current = nums[0], bound = nums.length / 3;
        for (int num : nums) {
            if (num == current) count++;
            else {
                if (count > bound) res.add(current);
                count = 1;
                current = num;
            }
        }
        if (count > bound) res.add(current);
        return res;
    }

    // 摩尔投票升级版
    // 格式：第一步对count=0情况，赋值num；第二步比较，相等情况单独的count++，不相等情况所有count--。
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0, n = nums.length;
        for (int num : nums) {
            // 赋num1和num2初始值，以及更新值
            if (count1 == 0) num1 = num;
            else if (count2 == 0) num2 = num;
            // 比较并更新count1和count2
            if (num == num1) count1++;
            else if (num == num2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        // 由于不保证一定存在，需要验证num1和num2
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
        }
        if (count1 > n / 3) res.add(num1);
        if (count2 > n / 3) res.add(num2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement2().majorityElement(
                new int[]{3, 2, 3}
        ));
        System.out.println(new MajorityElement2().majorityElement(
                new int[]{1, 1, 1, 3, 3, 2, 2, 2}
        ));
    }
}
