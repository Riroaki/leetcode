/**
 * Definition for a binary tree node.
 */

public class ConstructBinaryTreeFromInPost {
    private TreeNode build(int[] in, int s1, int e1, int[] post, int s2, int e2) {
        if (s1 > e1 || s2 > e2 || e1 - s1 != e2 - s2) return null;
        int rootVal = post[e2];
        TreeNode root = new TreeNode(rootVal);
        int index = s1;
        for (; index <= e1; index++)
            if (in[index] == rootVal)
                break;
        int leftNodeCount = index - s1;
        root.left = build(in, s1, index - 1, post, s2, s2 + leftNodeCount - 1);
        root.right = build(in, index + 1, e1, post, s2 + leftNodeCount, e2 - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    static private void printPre(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPre(root.left);
            printPre(root.right);
        }
    }

    static private void printIn(TreeNode root) {
        if (root != null) {
            printIn(root.left);
            System.out.print(root.val + " ");
            printIn(root.right);
        }
    }

    static private void printPost(TreeNode root) {
        if (root != null) {
            printPost(root.left);
            printPost(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new ConstructBinaryTreeFromInPost().buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );
        printPre(tree);
        System.out.println();
        printIn(tree);
        System.out.println();
        printPost(tree);
    }
}
