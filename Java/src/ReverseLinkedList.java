public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null, next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        return curr;
    }
}
