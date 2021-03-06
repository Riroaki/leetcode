import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 0, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, int level, TreeNode root) {
        if (root == null)
            return;
        if (res.size() < level + 1)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        dfs(res, level + 1, root.left);
        dfs(res, level + 1, root.right);
    }
}
