import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // iterative sol.
    // time complexity: O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        // 初始化一个大小为2的n次的List
        List<List<Integer>> powerSet = new ArrayList<>(1 << nums.length);
        // 加入空集作为第一个集合
        powerSet.add(new ArrayList<>());
        // 对于每个数，每个集合要么没有它，要么有它；所以可以如此迭代获得：
        for (int i : nums) {
            // 注意这里，powerSet的大小会时刻改变，所以要先取固定值作为边界
            int bound = powerSet.size();
            for (int index = 0; index < bound; index++) {
                List<Integer> tmp = new ArrayList<>(powerSet.get(index));
                tmp.add(i);
                powerSet.add(tmp);
            }
        }
        return powerSet;
    }

    // Backtrack sol, as fast as the iterative solution.
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
