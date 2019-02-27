public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head, odd = new ListNode(0), even = new ListNode(0),
            oddHead = odd, evenHead = even;
        boolean isOdd = true;
        while (curr != null) {
            if (isOdd) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }
            isOdd = !isOdd;
            curr = curr.next;
        }
        // 这一步很关键！假如最后一个是odd节点，
        // 不能忘记把even的下一个变成null
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
