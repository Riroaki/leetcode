import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // Queue of nodes at each level.
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);// Add root.
        while (!levelQueue.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            for (int i = 0, j = levelQueue.size(); i < j; i++) {
                TreeNode tmp = levelQueue.poll();
//                assert tmp != null;
                thisLevel.add(tmp.val);
                if (tmp.left != null) levelQueue.offer(tmp.left);
                if (tmp.right != null) levelQueue.offer(tmp.right);
            }
            res.add(thisLevel);
        }
        // Reverse the list.
        for (int i = 0, j = res.size() - 1; i < j; i++, j--) {
            List<Integer> tmp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, tmp);
        }
        return res;
    }
}
