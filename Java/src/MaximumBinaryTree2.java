public class MaximumBinaryTree2 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode res = root, parent = root;
        while (root.val > val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return res;
            }
            parent = root;
            root = root.right;
        }
        TreeNode node = new TreeNode(val);
        if (root != parent) {
            node.left = root;
            parent.right = node;
        } else {
            node.left = root;
            res = node;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new MaximumBinaryTree2().insertIntoMaxTree(root, 5));
    }
}
