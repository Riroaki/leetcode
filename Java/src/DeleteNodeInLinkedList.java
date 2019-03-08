public class DeleteNodeInLinkedList {
    // O(n) sol, Naive
    public void deleteNodeNaive(ListNode node) {
        ListNode next = node.next, curr = node;
        // 这是不允许的
        if (next == null)
            return;
        while (next.next != null) {
            curr.val = next.val;
            curr = next;
            next = next.next;
        }
        curr.val = next.val;
        curr.next = null;
    }

    // O(1) sol. Wonderful!
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
