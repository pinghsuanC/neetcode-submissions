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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode saveHead = head;
        ListNode cur = head, pos = new ListNode(0, head);
        int acc = 0;
        while(cur != null){
            acc++;
            if(acc >= n + 1) pos = pos.next;
            cur=cur.next;
        }

        if(acc == n){
            ListNode tmp = head.next;
            head.next = null;
            return tmp;
        }

        pos.next = pos.next.next;

        return head;
    }
}
