public class DoesNodeExistCompleteTree {
    public boolean doesNodeExist(TreeNode root, int id) {
        if (id <= 0) return false;
        char[] binary = Integer.toBinaryString(id).toCharArray();
        for (int i = 1; i < binary.length; i++) {
            if (root == null) return false;
            if (binary[i] == '0') root = root.left;
            else root = root.right;
        }
        return root != null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        System.out.println(new DoesNodeExistCompleteTree().doesNodeExist(root, 4));
        System.out.println(new DoesNodeExistCompleteTree().doesNodeExist(root, 7));
    }
}
