import java.util.*;

public class FindModeBST {
    HashMap<Integer, Integer> res;

    private void find(TreeNode root) {
        if (root == null)
            return;
        int value = root.val;
        if (!res.containsKey(value))
            res.put(value, 0);
        res.put(value, res.get(value) + 1);
        find(root.left);
        find(root.right);
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        res = new HashMap<>();
        find(root);
        return new int[0];
    }
}
