public class PathSum3 {
    // Wrong solution:
    // 这里为什么错？因为当我选择向左走的时候，如果我选择包含root，但是在左节点选择不包含，那么再往下走其实是非法的！
    // 所以答案比正确答案多
    /*
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = sum == root.val ? 1 : 0;
        res += pathSum(root.left, sum) + pathSum(root.left, sum - root.val);
        res += pathSum(root.right, sum) + pathSum(root.right, sum - root.val);
        return res;
    }
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int target) {
        if (root == null)
            return 0;
        int res = target == root.val ? 1 : 0;
        target  -= root.val;
        res += helper(root.left, target) + helper(root.right, target);
        return res;
    }

    // O(n log n) or O(n^2), as the tree is complete binary tree or singlely-linked tree.
    // start from each node while traveling
    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        travel(root, sum);
        return count;
    }

    private void travel(TreeNode root, int sum) {
        if (root == null)
            return;
        helper1(root, sum);
        travel(root.left, sum);
        travel(root.right, sum);
    }

    private void helper1(TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.val == sum)
            count++;
        sum -= root.val;
        helper1(root.left, sum);
        helper1(root.right, sum);
    }
}
