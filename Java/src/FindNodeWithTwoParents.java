public class FindNodeWithTwoParents {
    private Map<TreeNode, TreeNode> nodes;
    private TreeNode troubleNode, father1, father2;

    private void traverse(TreeNode root) {
        if (root == null || troubleNode != null)
            return;
        for (TreeNode tmp : new TreeNode[]{root.left, root.right}) {
            if (tmp != null) {
                if (nodes.containsKey(tmp) {
                    troubleNode = tmp;
                    father1 = nodes.get(tmp);
                    father2 = root;
                    break;
                } else {
                    nodes.put(tmp, root);
                    traverse(tmp);
                }
            }
        }
    }

    public TreeNode findNode(TreeNode root) {
        nodes = new HashMap<>();
        troubleNode = father1 = father2 = null;
        traverse(root);
        if (troubleNode == null)
            return null;
        // deal with father nodes and make the tree normal.
        if (father1.left == troubleNode)
            father1.left = null;
        else
            father1.right = null;
        return troubleNode;
    }
}
