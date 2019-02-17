public class BalancedBinaryTree {
    boolean res = true;

    private int depth(TreeNode root) {
        if(root == null) return 0;
        int lh = depth(root.left), rh = depth(root.right);
        if(Math.abs(lh - rh) >= 2) res = false;
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        depth(root);
        return res;
    }
}

class BalanceBinaryTree2 {
    private int checkDepth(TreeNode root) {

    }

    public boolean isBalanced(TreeNode root) {
        return 
    }
}
