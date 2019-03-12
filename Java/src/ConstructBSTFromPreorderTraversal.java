import java.util.Arrays;

public class ConstructBSTFromPreorderTraversal {
    // O(n lgn) naive version.
    // Distinct numbers.
    private TreeNode build(int[] pre, int from1, int to1, int[] in, int from2) {
        if (from1 == to1)
            return null;
        TreeNode root = new TreeNode(pre[from1]);
        int i = Arrays.binarySearch(in, pre[from1]);
        root.left = build(pre, from1 + 1, i - from2 + from1 + 1, in, from2);
        root.right = build(pre, i - from2 + from1 + 1, to1, in, i + 1);
        return root;
    }

    public TreeNode bstFromPreorderNaive(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];
        System.arraycopy(preorder, 0, inorder, 0, n);
        Arrays.sort(inorder);
        return build(preorder, 0, n, inorder, 0);
    }

    // O(n) version, straightforward
    private TreeNode helper(int[] pre, int from, int to) {
        if (from == to)
            return null;
        TreeNode root = new TreeNode(pre[from]);
        int index;
        for (index = from + 1; index < to; index++) {
            if (pre[index] > pre[from])
                break;
        }
        root.left = helper(pre, from + 1, index);
        root.right = helper(pre, index, to);
        return root;
    }

    public TreeNode bstFromPreorder(int[] pre) {
        return helper(pre, 0, pre.length);
    }
}
