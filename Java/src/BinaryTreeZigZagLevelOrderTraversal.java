import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 0, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, int level, TreeNode root) {
        if (root == null)
            return;
        if (res.size() < level + 1)
            res.add(new ArrayList<>());
        if (level % 2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        dfs(res, level + 1, root.left);
        dfs(res, level + 1, root.right);
    }
}
