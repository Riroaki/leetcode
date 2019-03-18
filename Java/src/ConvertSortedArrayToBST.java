public class ConvertSortedListToBST {
    // 空间O(1)但是时间O(n log n)的做法（当然，空间要算上递归栈也是O(n)）
    // 1ms 96.5%
    // 就好像把数组还原成平衡二叉树，对每个[left, right]进行操作
    // 时间复杂度：每次都要遍历链表的一半，层数是log n，所以复杂度是n log n
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    // 先找到中点，然后再进行复原
    public TreeNode helper(ListNode from, ListNode to) {
        if (from == to)
            return null;
        ListNode mid = from, end = from;
        while (end != to && end.next != to) {
            mid = mid.next;
            end = end.next;
        }
        TreeNode root = new TreeNode(mid);
        root.left = helper(from, mid);
        root.right = helper(mid.next, to);
        return root;
    }

    // 空间和时间都是O(n)的做法
    // 先把链表转化为数组，时间复杂度O(n)
    // 和上面那个相比其实是空间换时间了
    public TreeNode sortedListToBST2(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return helper2(nums, 0, nums.size());
    }

    private TreeNode helper2(List<Integer> nums, int from, int to) {
        if (from == to)
            return null;
        int mid = from + (to - from) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper2(nums, from, mid);
        root.right = helper2(nums, mid + 1, to);
        return root;
    }
}
