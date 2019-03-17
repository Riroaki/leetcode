public class Permutation {
    private List<List<Integer>> res;
    private boolean[] isUsed;
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        isUsed = new boolean[nums.length];
        backTrack(new ArrayList<>(), nums);
        return res;
    }

    private void backTrack(List<Integer> curr, int[] nums) {    
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));// Add by copy, not add by reference.
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i])
                continue;
            isUsed[i] = true;
            curr.add(nums[i]);
            backTrack(curr, nums);
            isUsed[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
