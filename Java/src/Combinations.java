public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k)
            return res;
        helper(res, new ArrayList<>(), 1, n, k);
        retrun res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int index, int n, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n; i++) {
            curr.add(i);
            helper(res, curr, i, i + 1, k);
            curr.remove(curr.size() - 1);
        }
    }
}
