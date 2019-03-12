import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal {
    // 最简单的，递归遍历，时间空间复杂度O(n)，但是容易stackOverFlow
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    // 使用stack遍历，空间复杂度和时间复杂度都是O(n)
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> roots = new Stack<>();
        while (root != null || !roots.isEmpty()) {
            // 存下从当前节点到其最左的子树的所有节点
            while (root != null) {
                roots.push(root);
                root = root.left;
            }
            // 从最左节点开始回溯
            root = roots.pop();
            res.add(root.val);
            // 如果right是空的，那么root设置为空，等到下一轮继续回溯；
            // 如果right非空，那么root设置为右节点并从下一轮遍历root的左子树
            root = root.right;
        }
        return res;
    }

    // 神奇的Morris遍历，可以在O(1)空间完成遍历
    // 时间复杂度是O(n)因为一共需要两次遍历，
    // 第一次是设置叶子节点的右孩子成为前驱节点，第二次是找到并遍历输出节点。
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode parent = root, child = null;
        while (parent != null) {
            // 中序的左、中
            if (parent.left == null) {
                res.add(parent.val);
                parent = parent.right;
            } else {
                // child是左子树
                child = parent.left;
                // 如果是是第一次，确认前驱节点时；
                // child找到最右子树并指向parent，parent变成左子树
                // 如果是第二次，
                // parent向右，可以找到自己的父亲。这个时候需要将child节点的右指针恢复为null
                while (child.right != null && child.right != parent)
                    child = child.right;
                if (child.right == null) {
                    child.right = root;
                    root = root.left;
                } else {
                    // 前驱节点
                    child.right = null;
                    res.add(parent.val);
                    parent = parent.right;
                }
            }
        }
        return res;
    }
}
