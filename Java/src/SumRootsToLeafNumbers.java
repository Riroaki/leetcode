public class SumRootToLeafNumbers {
    // 简单的回溯
    List<Integer> res;
    
    public int sumNumbers(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        int sum = 0;
        for (int n : res)
            sum += n;
        return sum;
    }
    
    private void helper(TreeNode root, int curr) {
        if (root == null)
            return;
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null)
            res.add(curr);
        else {
            helper(root.left, curr);
            helper(root.right, curr);
        }
        curr /= 10;
    }
}
