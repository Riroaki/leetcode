public class PathSum2 {
    // 这个代码。。我觉得怪怪的
    // 就是注意要在监测到是leaf的时候就加入res
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, new ArrayList<>(), sum);
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> curr, int target) {
        if (root == null)
            return;
        curr.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0)
            res.add(new ArrayList<>(curr));
        else {
            helper(root.left, res, curr, target);
            helper(root.right, res, curr, target);
        }
        curr.remove(curr.size() - 1);
    }
}
