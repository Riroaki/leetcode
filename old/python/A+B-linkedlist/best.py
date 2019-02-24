# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        head.next = l1
        carry = 0

        while l1 and l2:
            s = l1.val + l2.val + carry
            val, carry = s % 10, s // 10
            l1.val = val
            prev, l1, l2 = l1, l1.next, l2.next

        templ = l1 or l2
        prev.next = templ
        while templ and carry:
            s = templ.val + carry
            val, carry = s % 10, s // 10
            templ.val = val
            prev, templ = templ, templ.next

        if carry:
            prev.next = ListNode(1)

        return head.next
