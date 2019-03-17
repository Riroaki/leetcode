public class CountCompleteTreeNodes {
    // 以下两种方法的时间都是1ms，但是理论复杂度不同

    // Naive version. O(n)
    public int countNodesNaive(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Advanced version. O(log n * log n)
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int lo = 1, hi = 1;
        TreeNode tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
            hi = (hi << 1) + 1;
        }
        hi = (hi << 1) + 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (exist(root, mi))
                lo = mi + 1;
            else
                hi = mi;
        }
        return exist(root, lo) ? lo : lo - 1;
    }

    private boolean exist(TreeNode root, int x) {
        if (x <= 0)
            return false;
        int i = 1;
        String a = Integer.toBinaryString(x);
        for (; i < a.length() && root != null; i++) {
            if (a.charAt(i) == '1')
                root = root.right;
            else
                root = root.left;
        }
        return i == a.length() ? root != null : false;
    }
}
