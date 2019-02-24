public class ConvertSortedArrayToBalancedBST {
    // 0ms, beats 100% of Java
    // Build a tree from start to end (including end)
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }
}

class ConvertSortedArrayToBalancedBST2 {
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start >= end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : buildTree(nums, 0, nums.length);
    }
}
