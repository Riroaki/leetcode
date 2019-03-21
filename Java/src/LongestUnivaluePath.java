public class LongestUnivaluePath {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root ==  null)
            return 0;
        int left = helper(root.left), right = helper(root.right);
        int tmp1 = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int tmp2 = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res = Math.max(res, tmp1 + tmp2);
        return Math.max(tmp1, tmp2);
    }
}
