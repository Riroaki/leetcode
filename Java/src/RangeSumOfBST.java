public class RangeSumOfBST {
    // version 1
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);
        if(root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    // version 2
    private int res;

    private void helper(TreeNode root, int l, int r) {
        if (root == null)
            return;
        if (root.val >= l && root.val <= r)
            res += root.val;
        if (root.val < r)
            helper(root.right, l, r);
        if (root.val > l)
            helper(root.left, l, r);
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        res = 0;
        if (L > R)
            return 0;
        helper(root, L, R);
        return res;
    }
}
