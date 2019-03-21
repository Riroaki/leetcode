public class HouseRobber3 {
    // 这绝对是我见过最dio的分析！三种算法层层推进，将dp讲解的一清二楚
    // Naive version.
    public int robNaive(TreeNode root) {
        if (root == null)
            return 0;
        int r = root.val, nr = rob(root.left) + rob(root.right);
        if (root.left != null)
            r += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            r += rob(root.right.left) + rob(root.right.right);
        return Math.max(r, nr);
    }

    // 4ms.
    // Use dp, and records the value of each node.
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> dp = new HashMap<>();
        return helper(root, dp);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null)
            return 0;
        if (dp.containsKey(root))
            return dp.get(root);
        int r = root.val, nr = helper(root.left, dp) + helper(root.right, dp);
        if (root.left != null)
            r += helper(root.left.left, dp) + helper(root.left.right, dp);
        if (root.right != null)
            r += helper(root.right.left, dp) + helper(root.right.right, dp);
        int res = Math.max(r, nr);
        dp.put(root, res);
        return res;
    }

    // 0ms 100%.
    // final best sol.
    // return array of [not rob, rob] and therefore reduces the overlapping of subproblems.
    public int rob1(TreeNode root) {
        int[] res = helper1(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper1(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = helper1(root.left);
        int[] right = helper1(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
