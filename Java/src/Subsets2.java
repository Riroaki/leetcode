public class Subsets2 {
    // 1 ms 100% using back track. This is a powerful sol.
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backTrack(new ArrayList<>(), nums, 0);
        return res;
    }

    private void backTrack(List<Integer> curr, int[] nums, int index) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            curr.add(nums[i]);
            backTrack(curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
