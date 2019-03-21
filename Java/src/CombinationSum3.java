public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > 9 || k < 1 || n > (19 - k) * k / 2 || n < (k + 1) * k / 2)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int index, int k, int target) {
        if (curr.size() > k || target < 0)
            return;
        if (curr.size() == k) {
            if (target == 0)
                res.add(new ArrayList<>(curr));
        } else {
            for (int i = index; i < 10; i++) {
                curr.add(i);
                helper(res, curr, i + 1, k, target - i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
