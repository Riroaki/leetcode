import java.util.Stack;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
    }

    public boolean isSymmetricStack(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode a = stack.pop(), b = stack.pop();
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            stack.push(a.left);
            stack.push(b.right);
            stack.push(a.right);
            stack.push(b.left);
        }
        return true;
    }
}
