# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# 发现：如果把getVal和getNext函数改成a if b else c的形式会更慢？？
class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        nodes = []
        p, q = l1, l2
        carry, tempSum = 0, 0
        while p or q:
            tempSum = self.getVal(p) + self.getVal(q) + carry
            p, q = self.getNext(p), self.getNext(q)
            carry, tempSum = tempSum // 10, tempSum % 10
            nodes.append(ListNode(tempSum))
        if carry:
            nodes.append(ListNode(carry))
        for i in range(len(nodes) - 1):
            nodes[i].next = nodes[i + 1]
        return nodes[0]

    def getVal(self, node):
        if node:
            return node.val
        return 0

    def getNext(self, node):
        if node:
            return node.next
        return None
