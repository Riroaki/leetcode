public class FlattenBinaryTreeToLinkedList {
    // flatten左右子树，然后按题意操作
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        TreeNode left = root.left, right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null)
            root = root.right;
        root.right = right;
    }
}
