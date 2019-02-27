public class ValidateBST {
    // 1, 最简单的想法，递归对BST检查左子树和右子树，并用root的值进一步缩小范围
    // 注意使用long作为检测，因为节点的val可能是Integer.MAX_VALUE
    private boolean isValid(TreeNode root, long lo, long hi) {
        if (root.val <= lo || root.val >= hi)
            return false;
        boolean left = true, right = true;
        if (root.left != null)
            left = isValid(root.left, lo, root.val);
        if (root.right != null)
            right = isValid(root.right, root.val, hi);
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 2，iterative做法避免stackOverFlow
    public boolean isValidBSTIterative(TreeNode root) {
        //...
        return false;
    }
}
