public class RecoverBST {
    // O(n) space solution.
    private List<Integer> toArray(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    
    private TreeNode find(TreeNode root, int val) {
        Stack<TreeNode> nodes = new Stack<>();
        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.pop();
            if (root.val == val)
                return root;
            root = root.right;
        }
        return null;
    }
    
    public void recoverTree(TreeNode root) {
        List<Integer> values = toArray(root);
        int[] change = new int[]{-1, -1};
        // 根据下降趋势，找到两个异位的点：
        // 这里有两种情况。
        // a. [1, 2, 3, 4] -> [1, 3, 2, 4]，在3到2这里有一个交换，此时异位的节点是2和3
        // b. [1, 2, 3, 4, 5] -> [1, 5, 3, 4, 2]，在5到3和4到2的地方有两个交换，此时异位节点为5和2
        // 所以我们记录两个下降处的情况
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                if (change[0] == -1)
                    change[0] = i;
                else
                    change[1] = i;
            }
        }
        // 如果只有一个下降处，那么第二个数就在下降处右侧
        if (change[1] == -1)
            change[1] = change[0] + 1;
        else// 如果有两个下降处，第二个数在第二个下降处右侧
            change[1]++;
        change[0] = values.get(change[0]);
        change[1] = values.get(change[1]);
        TreeNode s1 = find(root, change[0]),
            s2 = find(root, change[1]);
        s1.val = change[1];
        s2.val = change[0];
    }
}
