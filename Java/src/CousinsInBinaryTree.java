public class CousinsInBinaryTree {
    TreeNode node;

    private int findDepth(TreeNode root, int num) {
        if(root == null) return -1;
        if(root.val == num) return 0;
        int left = findDepth(root.left, num), right = findDepth(root.right, num);
        if(left==0 || right == 0) node = root;
        if(left != -1) return left + 1;
        if(right != -1) return right + 1;
        return -1;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int dep1 = findDepth(root, x);
        TreeNode parentX = node;
        int dep2 = findDepth(root, y);
        TreeNode parentY = node;
        return dep1 != -1 && dep2 != -1 && dep1 == dep2 && parentX != parentY;
    }
}
