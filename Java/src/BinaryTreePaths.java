public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, root, new ArrayList<>());
        return res;
    }

    private void helper(List<String> res, TreeNode root, List<Integer> curr) {
        if (root == null)
            return;
        curr.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curr.size(); i++) {
                if (i > 0)
                    sb.append("->");
                sb.append(curr.get(i));
            }
            res.append(sb.toString());
        } else {
            helper(res, root.left, curr);
            helper(res, root.right, curr);
        }
        curr.remove(curr.size() - 1);
    }
}
