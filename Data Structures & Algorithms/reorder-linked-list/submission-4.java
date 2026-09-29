/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // intuition: it's zipping two halfs of the linked list
        // 1 -> find the mid point (fast and slow pointer)
        // 2 -> reverse the 2nd half (list reversal)
        // 3 -> zip the lists together

        if(head == null || head.next == null) return;

        // find the mid point
        ListNode h = head;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null; // break the halfs

        // reverse the second half
        ListNode l2 = reverse(mid);

        // zip two lists
        zip(head, l2);
    }

    private ListNode zip(ListNode l1, ListNode l2){
        ListNode cur1 = l1, cur2 = l2;
        while(cur2 != null){
            ListNode tmp1 = cur1.next;
            ListNode tmp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = tmp1;
            cur2 = tmp2;
            cur1 = tmp1;
        }
        return l1;
    }

    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode pre = null,
                cur = head;
        
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
