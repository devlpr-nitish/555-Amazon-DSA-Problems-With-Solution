

public class MTSOLL {
    public int pairSum(ListNode head) {

        // First find the mid of the linked list 
        ListNode midNode = findmid(head);
        //then reverse the linked list 2nd half which starts from mid 
        ListNode mid = reverse(midNode);
        ListNode curr = head;
        int maxsum = 0;
        // go till mid not equal to null 
    
        while (mid != null) {
            
            maxsum = Math.max(maxsum, mid.val + curr.val);
            curr = curr.next;
            mid = mid.next;
        }

        return maxsum;

    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode findmid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
