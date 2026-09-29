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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /**
        intuition:
        since left and right are zero-index, the actual position = l - 1, r-1
        1. go to position l-2 and r-1
        2. preserve l-2 and (r-1).next, move left pointer to l-1, these are where the connections will be recoonected to
        3. delink l-2.next and r-1.next (preserve l-1)
        4. reverse (l-1 to r-1)
        5. reconnect the parts

        **/

        if(head == null || head.next == null || left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode l = dummy, r = dummy;
        for(int i = 0; i < left - 1; i++) l = l.next;
        for(int i = 0; i < right; i++) r = r.next;

        

        ListNode nextToR = r.next;
        ListNode preToL = l;
        
        // disconnect the lists
        l = l.next;
        r.next = null;
        preToL.next = null;
        // reverse
        reverse(l);
        // connect the parts back
        preToL.next = r;
        l.next = nextToR;


        return dummy.next;
    }

    public ListNode[] reverse(ListNode head){
        if(head == null) return new ListNode[]{null, null};
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return new ListNode[]{pre, head}; // head & tail
    }
}