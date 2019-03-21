public class SmallestStringStartingFromLeaf {
    // 千万注意，stringbuilder的reverse是原地操作，记得恢复原来顺序
    // 另外，setLength可以截取部分字符串；
    // insert会把后面的字符串后移，因为本质基于char[]。
    // 思路：遍历得到所有的反向的路径，保留最小的（如果全部保留+排序，效率会更低）
    // 复杂度：O(n)
    private String res;

    public String smallestFromLeaf(TreeNode root) {
        res = "";
        helper(root, new StringBuilder());
        return res;
    }

    private void helper(TreeNode root, StringBuilder curr) {
        if (root == null)
            return;
        char tmp = (char)('a' + root.val);
        curr.append(tmp);
        if (root.left == null && root.right == null) {
            String currStr = curr.reverse().toString();
            if (res.equals("") || res.compareTo(currStr) > 0)
                res = currStr;
            curr.reverse();
        } else {
            helper(root.left, curr);
            helper(root.right, curr);
        }
        curr.setLength(curr.length() - 1);
    }
}
