public class Permutation2 {
    // 100% 2ms，见到过的最优解法。
    // 基本原理：如果在一个排列中出现相同数，那么只要保证相同数之间的有序，就可以得到unique的排列
    // 当然，也有用set实现的
    private List<List<Integer>> res;
    private boolean[] isUsed;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        isUsed = new boolean[nums.length];
        backTrack(new ArrayList<>(), nums);
        return res;
    }

    private void backTrack(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 精妙的逻辑
            // 如果用的是isUsed[i - 1]而不是!isUsed[i - 1]，速度会更慢一点
            // 这里，在前一个数没有被用的时候，是不会填这个数的，确保了相同的数在排列后的有序性，从而避免了乱序
            // 与此同时，如果采用isUsed[i - 1]的话，那么就是让这个数在前一个数之前，本质也是一个意思
            if (isUsed[i] || (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1])
                continue;
            isUsed[i] = true;
            curr.add(nums[i]);
            backTrack(curr, nums);
            curr.remove(curr.size() - 1);
            isUsed[i] = false;
        }
    }
}
