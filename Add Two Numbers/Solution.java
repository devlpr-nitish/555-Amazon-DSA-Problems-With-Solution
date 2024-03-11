/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        int carry = 0;
        ListNode l1 = head1;
        ListNode l2 = head2;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            ListNode temp = new ListNode();

            temp.val = sum % 10;
            carry = sum / 10;

            curr.next = temp;
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            curr.next = temp;
        }

        return result.next;
    }
}