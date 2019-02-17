public class BalancedBinaryTree {
    boolean res = true;

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int lh = depth(root.left), rh = depth(root.right);
        if (Math.abs(lh - rh) >= 2) res = false;
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        depth(root);
        return res;
    }
}

class BalanceBinaryTree2 {
    private int checkDepth(TreeNode root) {
        int lh = root.left == null ? 0 : checkDepth(root.left),
                rh = root.right == null ? 0 : checkDepth(root.right);
        if (lh == -1 || rh == -1) return -1;
        if (lh - rh > 1 || lh - rh < -1) return -1;
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return root == null || checkDepth(root) != -1;
    }
}
