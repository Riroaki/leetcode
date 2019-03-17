public class CombinationSum2 {
    private List<List<Integer>> res;

    // 如果要去除duplicate，就排序；并且和前一个比较来判断
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backTrack(new ArrayList<>(), nums, target, 0);
        return res;
    }

    private void backTrack(List<Integer> curr, int[] nums, int target, int index) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i])
                continue;// skip duplicates.
            curr.add(nums[i]);
            backTrack(curr, nums, target - nums[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
