#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int pairSum(ListNode *head)
    {
        // First find the mid of the linked list
        ListNode *midNode = findmid(head);
        // then reverse the linked list 2nd half which starts from mid
        ListNode *mid = reverse(midNode);
        ListNode *curr = head;
        int maxsum = 0;
        // go till mid not equal to null

        while (mid != NULL)
        {

            maxsum = max(maxsum, mid->val + curr->val);
            curr = curr->next;
            mid = mid->next;
        }

        return maxsum;
    }

    ListNode *reverse(ListNode *head)
    {

        ListNode *prev = NULL;
        ListNode *current = head;
        ListNode *next = NULL;
        while (current != NULL)
        {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    ListNode *findmid(ListNode *head)
    {

        ListNode *slow = head;
        ListNode *fast = head;

        while (fast != NULL && fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }
};

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};