public class PathSum {
    private int target;// The variable target is used to reduce stack cost, otherwise it will be used as a parameter of method helper.

    private boolean helper(TreeNode root, int current) {
        boolean left = false, right = false;
        current += root.val;
        // Only check if this node is a leaf node.
        if (root.left == null && root.right == null) return current == target;
        // Check left subtree.
        if (root.left != null) left = helper(root.left, current);
        // Check right subtree.
        if (root.right != null) right = helper(root.right, current);
        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;// Actually I think it should return sum == 0, but the judge said no:P
        target = sum;
        return helper(root, 0);
    }
}

class PathSumBest {
    // Here is a simpler one...
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}