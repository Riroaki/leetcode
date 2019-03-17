import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {
    private int maxSum(int nums[], int n) {
        int res = 0, len = nums.length;
        for (int i = 1; i <= n; i++)
            res += nums[len - i];
        return res;
    }
    
    private int minSum(int[] nums, int n, int index) {
        int res = 0;
        for (int i = 0; i < n; i++)
            res += nums[i + index];
        return res;
    }
    
    private List<List<Integer>> nSum(int[] nums, int target, int n, int index) {
        if (nums.length - index < n || maxSum(nums, n) < target || minSum(nums, n, index) > target)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 2 sum
        if (n == 2) {
            int lo = index, hi = len - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] < target) {
                    do {
                        lo++;
                    } while (lo < hi && nums[lo] == nums[lo - 1]);
                } else {// >= target
                    if (nums[lo] + nums[hi] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[lo]);
                        tmp.add(nums[hi]);
                        res.add(tmp);
                    }
                    do {
                        hi--;
                    } while (lo < hi && nums[hi] == nums[hi + 1]);
                }
            }
        } else {// n sum
            int start = index;
            while (start <= len - n) {
                List<List<Integer>> tmp = nSum(nums, target - nums[start], n - 1, start + 1);
                for (List<Integer> a : tmp) {
                    a.add(nums[start]);
                    res.add(a);
                }
                do {
                    start++;
                } while (start <= len - n && nums[start] == nums[start - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, -1, -3, 0, -2};
        Arrays.sort(a);
        System.out.println(new NSum().nSum(a));
    }
}
