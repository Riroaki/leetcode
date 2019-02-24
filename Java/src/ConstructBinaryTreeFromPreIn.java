/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class ConstructBinaryTreeFromPreIn {
    private TreeNode build(int[] pre, int s1, int e1, int[] in, int s2, int e2) {
        if (s1 > e1 || s2 > e2 || e1 - s1 != e2 - s2) return null;
        int rootVal = pre[s1];
        TreeNode root = new TreeNode(rootVal);
        int index = s2;
        for (; index <= e2; index++)
            if (in[index] == rootVal)
                break;
        int leftNodeCount = index - s2;
        root.left = build(pre, s1 + 1, s1 + leftNodeCount, in, s2, index - 1);
        root.right = build(pre, s1 + leftNodeCount + 1, e1, in, index + 1, e2);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
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
        TreeNode tree = new ConstructBinaryTreeFromPreIn().buildTree(
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
