#include <bits/stdc++.h>
using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *head1, ListNode *head2)
    {
        ListNode *result = new ListNode(-1);
        ListNode *curr = result;
        int carry = 0;
        ListNode *l1 = head1;
        ListNode *l2 = head2;
        while (l1 != NULL || l2 != NULL)
        {
            int sum = carry;
            if (l1 != NULL)
            {
                sum += l1->val;
            }
            if (l2 != NULL)
            {
                sum += l2->val;
            }
            ListNode *temp = new ListNode();

            temp->val = sum % 10;
            carry = sum / 10;

            curr->next = temp;
            curr = curr->next;

            if (l1 != NULL)
            {
                l1 = l1->next;
            }
            if (l2 != NULL)
            {
                l2 = l2->next;
            }
        }
        if (carry != 0)
        {
            ListNode *temp = new ListNode(carry);
            curr->next = temp;
        }

        return result->next;
    }
};