public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode middleNodeNaive(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        int count = 0;
        while (fast != null) {
            count++;
            fast = fast.next;
        }
        count /= 2;
        while (count > 0) {
            slow = slow.next;
            count--;
        }
        return slow;
    }
}
