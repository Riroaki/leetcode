import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // Sort and binary search in 2sum, O(n^2) time complexity
    // 2 sum 可以使用双指针法（n复杂度），也可以二分查找（n*lgn复杂度）
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, i = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (i < n - 2) {
            List<List<Integer>> two = twoSum(nums, i + 1, n - 1, -nums[i]);
            res.addAll(two);
            i++;
            while (i < n - 2 && nums[i] == nums[i - 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int from, int to, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums[from] << 1 > target || nums[to] << 1 < target) return res;
        while (from < to) {
            if (nums[from] + nums[to] == target) {
                res.add(Arrays.asList(-target, nums[from], nums[to]));
                from++;
                while (from < to && nums[from] == nums[from - 1]) from++;
                to--;
                while (from < to && nums[to] == nums[to + 1]) to--;
            } else if (nums[from] + nums[to] < target) from++;
            else to--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 1, -2, 2}));
    }
}
