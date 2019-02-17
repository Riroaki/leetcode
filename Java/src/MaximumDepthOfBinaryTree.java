import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public int maxDepthStack(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);
        int maxDepth = 1;
        while (!nodeStack.isEmpty()) {
            TreeNode tmp = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (tmp.left != null) {
                nodeStack.push(tmp.left);
                depthStack.push(depth + 1);
            }
            if (tmp.right != null) {
                nodeStack.push(tmp.right);
                depthStack.push(depth + 1);
            }
        }
        return maxDepth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
