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
    public ListNode reverseKGroup(ListNode head, int k) {
        // intuition:
        // think of it as 2 parts, 0 to k and k to end
        // each part needs to be reversed and connected in the middle
        // in the first part, check if there are even k nodes
            // if no, return head as it is
        // now reverse as normal, with pre and cur
        // at the end, call recerseKGroup again on cur, attach to head.next

        if(head == null || head.next == null) return head;
        ListNode check = head;
        for(int i = 0; i < k; i++){
            if(check == null) return head;
            check = check.next;
        }

        ListNode cur = head, pre = null;
        int count = 0;
        while(count < k && cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            count++;
        }

        head.next = reverseKGroup(cur, k);
        return pre;
    }
}
