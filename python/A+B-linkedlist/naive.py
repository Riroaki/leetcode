# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# My solution: naive.
class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        s = self.getSum(l1) + self.getSum(l2)
        return self.makeList(s)

    def getSum(self, li):
        node = li
        mySum, exp = 0, 1
        while (node):
            mySum += node.val * exp
            node = node.next
            exp *= 10
        return mySum

    def makeList(self, total):
        nums = []
        if total == 0:
            return ListNode(0)
        while total:
            nums.append(total % 10)
            total //= 10
        nodes = [ListNode(num) for num in nums]
        for i in range(len(nums) - 1):
            nodes[i].next = nodes[i + 1]
        return nodes[0]
