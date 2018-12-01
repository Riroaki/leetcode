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
        while (l1 && l2)
        {
            sum = l1->val + l2->val + carry;
            carry = sum / 10;
            sum %= 10;

            current = new ListNode(sum);
            last->next = current;
            last = current;

            l1 = l1->next;
            l2 = l2->next;
        }
        ListNode *temp = NULL;
        if (l1)
            temp = l1;
        else
            temp = l2;
        while (temp)
        {
            sum = carry + temp->val;
            carry = sum / 10;
            sum %= 10;
            current = new ListNode(sum);
            last->next = current;
            last = current;
            temp = temp->next;
        }
        if (carry)
            last->next = new ListNode(carry);
        return head->next;
    }
};