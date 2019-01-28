import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {
    private int maxSum(int[] nums, int n) {
        int sum = 0, l = nums.length - 1;
        for (int i = 0; i < n; i++)
            sum += nums[l - i];
        return sum;
    }

    private int minSum(int[] nums, int n, int start) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[start + i];
        return sum;
    }

    private List<List<Integer>> nSumRecursive(int[] nums, int target, int n, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target)
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                else if (nums[left] + nums[right] > target)
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                }
            }
        } else {
            int first = start;
            while (first < nums.length - n + 1) {
                if (minSum(nums, n, first) > target)
                    break;
                if (nums[first] + maxSum(nums, n - 1) >= target) {
                    List<List<Integer>> pre_res = nSumRecursive(nums, target - nums[first], n - 1, first + 1);
                    for (List<Integer> l : pre_res) {
                        l.add(0, nums[first]);
                        res.add(l);
                    }
                }
                do {
                    first++;
                } while (first < nums.length - n + 1 && nums[first] == nums[first - 1]);
            }
        }
        return res;
    }

    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        if (n < 2 || nums.length < n || maxSum(nums, n) < target)
            return new ArrayList<>();
        return nSumRecursive(nums, target, n, 0);
    }

    public static void main(String[] args) {
        System.out.println(new NSum().nSum(new int[]{
                1, 1, 0, -1, -3, 0, -2
        }, -2, 4));
    }
}
