import java.util.Stack;

public class SameTree {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>(), stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.empty()) {
            TreeNode tmp1 = stackP.pop(), tmp2 = stackQ.pop();
            if (tmp1 == null && tmp2 == null) continue;
            if (tmp1 == null || tmp2 == null) return false;
            if (tmp1.val != tmp2.val) return false;
            stackP.push(tmp1.left);
            stackQ.push(tmp2.left);
            stackP.push(tmp1.right);
            stackQ.push(tmp2.right);
        }
        return true;
    }
}
