#include <iostream>
using namespace std;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution
{
  public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        int carry = 0, sum = 0;
        ListNode *head = new ListNode(0), *last = head, *current = NULL;
        while (l1 || l2)
        {
            int val1 = l1 ? l1->val : 0;
            int val2 = l2 ? l2->val : 0;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;

            current = new ListNode(sum);
            last->next = current;
            last = current;

            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }
        if (carry)
            last->next = new ListNode(carry);
        return head->next;
    }
};